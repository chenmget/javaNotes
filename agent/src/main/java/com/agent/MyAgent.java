package com.agent;

import java.lang.instrument.Instrumentation;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 18:30
 **/
public class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("嗨！JavaAgent " + agentArgs);
        MyMonitorTransformer monitor = new MyMonitorTransformer();
        inst.addTransformer(monitor);
    }

    //如果代理类没有实现上面的方法，那么 JVM 将尝试调用该方法
    public static void premain(String agentArgs) {
    }
}
