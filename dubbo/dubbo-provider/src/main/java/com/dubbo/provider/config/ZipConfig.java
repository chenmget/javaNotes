package com.dubbo.provider.config;

import com.github.kristofa.brave.Sampler;
import com.github.kristofa.brave.servlet.BraveServletFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.Sender;
import zipkin.reporter.okhttp3.OkHttpSender;

import java.util.concurrent.TimeUnit;


/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 18:48
 **/
@Configuration
public class ZipConfig {
    /**
     * 服务名称
     */
    @Value("${zipkin.serviceName}")
    private String serviceName;

    /**
     * zipkin地址
     */
    @Value("${zipkin.url}")
    private String url;

    /**
     * 连接时间
     */
    @Value("${zipkin.connectTimeout}")
    private int connectTimeout;

    /**
     * 读取时间
     */
    @Value("${zipkin.readTimeout}")
    private int readTimeout;

    /**
     * 每间隔多少秒执行一次Span信息上传
     */
    @Value("${zipkin.flushInterval}")
    private int flushInterval;

    /**
     * 是否启动压缩
     */
    @Value("${zipkin.compressionEnabled}")
    private boolean compressionEnabled;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getFlushInterval() {
        return flushInterval;
    }

    public void setFlushInterval(int flushInterval) {
        this.flushInterval = flushInterval;
    }

    public boolean isCompressionEnabled() {
        return compressionEnabled;
    }

    public void setCompressionEnabled(boolean compressionEnabled) {
        this.compressionEnabled = compressionEnabled;
    }

    @Bean(value = "tracing")
    public Tracing tracing() {
        Sender sender = OkHttpSender.create(this.getUrl());
        AsyncReporter reporter = AsyncReporter.builder(sender)
                .closeTimeout(this.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .messageTimeout(this.getReadTimeout(), TimeUnit.MILLISECONDS)
                .build();

        Tracing tracing = Tracing.newBuilder().localServiceName(this.getServiceName())
                .propagationFactory(ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "shiliew"))
                .sampler(Sampler.ALWAYS_SAMPLE)
                .spanReporter(reporter)
                .currentTraceContext(CurrentTraceContext.Default.create())
                .build();
        return tracing;
    }


    @Bean
    public FilterRegistrationBean testFilterRegistration(BraveServletFilter braveServletFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(braveServletFilter);
        registration.addUrlPatterns("/*");
        registration.setName("braveServletFilter");
        registration.setOrder(1);
        return registration;
    }
}
