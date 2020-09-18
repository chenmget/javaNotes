package com.dubbo.consumer.config;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 19:07
 **/
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSONObject;
import com.github.kristofa.brave.*;
import com.github.kristofa.brave.internal.Nullable;
import com.github.kristofa.brave.internal.Util;
import com.rt.platform.infosys.base.common.utils.BasePropertiesUtil;
import com.twitter.zipkin.gen.Span;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.Reporter;
import zipkin.reporter.Sender;
import zipkin.reporter.okhttp3.OkHttpSender;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Activate(group = Constants.CONSUMER)
public class DrpcClientInterceptor implements Filter {

    private final ClientRequestInterceptor clientRequestInterceptor;
    private final ClientResponseInterceptor clientResponseInterceptor;
    private final ClientSpanThreadBinder clientSpanThreadBinder;

    public DrpcClientInterceptor() {
        String sendUrl = BasePropertiesUtil.getProperty(ZipkinConstants.SEND_ADDRESS);
        Sender sender = OkHttpSender.create(sendUrl);
        Reporter<zipkin.Span> reporter = AsyncReporter.builder(sender).build();
        String application = BasePropertiesUtil.getProperty(ZipkinConstants.BRAVE_NAME);
        Brave brave = new Brave.Builder(application).reporter(reporter).build();
        this.clientRequestInterceptor = Util.checkNotNull(brave.clientRequestInterceptor(), null);
        this.clientResponseInterceptor = Util.checkNotNull(brave.clientResponseInterceptor(), null);
        this.clientSpanThreadBinder = Util.checkNotNull(brave.clientSpanThreadBinder(), null);
    }


    @Override
    public Result invoke(Invoker<?> arg0, Invocation arg1) throws RpcException {
        clientRequestInterceptor.handle(new GrpcClientRequestAdapter(arg1));
        Map<String, String> att = arg1.getAttachments();
        final Span currentClientSpan = clientSpanThreadBinder.getCurrentClientSpan();
        Result result;
        try {
            result = arg0.invoke(arg1);
            clientSpanThreadBinder.setCurrentSpan(currentClientSpan);
            clientResponseInterceptor.handle(new GrpcClientResponseAdapter(result));
        } finally {
            clientSpanThreadBinder.setCurrentSpan(null);
        }
        return result;
    }

    static final class GrpcClientRequestAdapter implements ClientRequestAdapter {
        private Invocation invocation;

        public GrpcClientRequestAdapter(Invocation invocation) {
            this.invocation = invocation;
        }

        @Override
        public String getSpanName() {
            String ls = invocation.getMethodName();
            String serviceName = ls == null ? "unkown" : ls;
            return serviceName;
        }

        @Override
        public void addSpanIdToRequest(@Nullable SpanId spanId) {
            Map<String, String> at = this.invocation.getAttachments();
            if (spanId == null) {
                at.put("Sampled", "0");
            } else {
                at.put("Sampled", "1");
                at.put("TraceId", spanId.traceIdString());
                at.put("SpanId", IdConversion.convertToString(spanId.spanId));
                if (spanId.nullableParentId() != null) {
                    at.put("ParentSpanId", IdConversion.convertToString(spanId.parentId));
                }
            }
        }


        @Override
        public Collection<KeyValueAnnotation> requestAnnotations() {
            Object[] arguments = invocation.getArguments();
//            Map data = ls.getData();
            KeyValueAnnotation an = KeyValueAnnotation.create("params", JSONObject.toJSONString(arguments));
            return Collections.singletonList(an);
        }

        @Override
        public com.twitter.zipkin.gen.Endpoint serverAddress() {
            return null;
        }
    }

    static final class GrpcClientResponseAdapter implements ClientResponseAdapter {

        private final Result result;

        public GrpcClientResponseAdapter(Result result) {
            this.result = result;
        }

        @Override
        public Collection<KeyValueAnnotation> responseAnnotations() {
            return Collections.<KeyValueAnnotation>emptyList();
            /*
            return !result.hasException()
                ? Collections.<KeyValueAnnotation>emptyList()
                : Collections.singletonList(KeyValueAnnotation.create("error", result.getException().getMessage()));
                */
        }
    }
}
