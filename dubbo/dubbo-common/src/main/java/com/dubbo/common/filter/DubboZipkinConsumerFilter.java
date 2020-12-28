package com.dubbo.common.filter;

import brave.Span;
import brave.Tracer;
import brave.Tracing;
import brave.propagation.TraceContext;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.support.RpcUtils;
import com.dubbo.common.helper.ZipkinHelper;


import java.util.Map;

@Activate(group = Constants.CONSUMER)
public class DubboZipkinConsumerFilter implements Filter {

    private SpringExtensionFactory springExtensionFactory = new SpringExtensionFactory();
    private Tracer tracer;

    // tracing上下文消息注入
    private TraceContext.Injector<Map<String, String>> injector;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("ccccccccccccccccccccccccccccccccccccccccccccccccccc");
        Tracing tracing = springExtensionFactory.getExtension(Tracing.class, "tracing");
        tracer = tracing.tracer();
        if (tracer == null){
            return invoker.invoke(invocation);
        }

        if (null == injector){
            injector = tracing.propagation().injector(ZipkinHelper.SETTER);
        }

        RpcContext rpcContext = RpcContext.getContext();
        Span span = tracer.nextSpan();
        injector.inject(span.context(), invocation.getAttachments());

        ZipkinHelper.buildSpan(span, Span.Kind.CONSUMER, rpcContext.getRemoteAddress(), invoker.getInterface().getSimpleName(),
                RpcUtils.getMethodName(invocation));

        return ZipkinHelper.spanTracing(span, tracer, invoker, invocation, rpcContext);
    }

}