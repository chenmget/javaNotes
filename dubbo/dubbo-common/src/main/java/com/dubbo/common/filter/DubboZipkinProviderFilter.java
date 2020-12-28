package com.dubbo.common.filter;

import brave.Span;
import brave.Tracer;
import brave.Tracing;
import brave.propagation.TraceContext;
import brave.propagation.TraceContextOrSamplingFlags;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.support.RpcUtils;
import com.dubbo.common.helper.ZipkinHelper;



import java.util.Map;


@Activate(group = Constants.PROVIDER)
public class DubboZipkinProviderFilter implements Filter {

    private SpringExtensionFactory springExtensionFactory = new SpringExtensionFactory();
    private Tracer tracer;

    // tracing上下文消息提取
    private TraceContext.Extractor<Map<String, String>> extractor;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("ppppppppppppppppppppppppppppppppppppppppppppppppp");

        Tracing tracing = springExtensionFactory.getExtension(Tracing.class, "tracing");
        tracer = tracing.tracer();
        if (null == tracer){
            return invoker.invoke(invocation);
        }

        if (null == extractor){
            extractor = tracing.propagation().extractor(ZipkinHelper.GETTER);
        }

        TraceContextOrSamplingFlags extracted = extractor.extract(invocation.getAttachments());
        Span span = extracted.context() != null
                ? tracer.joinSpan(extracted.context())
                : tracer.nextSpan(extracted);

        RpcContext rpcContext = RpcContext.getContext();
        ZipkinHelper.buildSpan(span, Span.Kind.SERVER, rpcContext.getRemoteAddress(), invoker.getInterface().getSimpleName(),
                RpcUtils.getMethodName(invocation));

        return ZipkinHelper.spanTracing(span, tracer, invoker, invocation, rpcContext);
    }
}