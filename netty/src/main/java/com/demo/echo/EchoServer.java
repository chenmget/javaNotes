package com.demo.echo;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-02 18:37
 **/
public class EchoServer {
    private final int port;

    public EchoServer(int port){
        this.port=port;
    }

    public static void main(String[] args) throws  Exception{
        new EchoServer(8080).start();
    }

    private void start() throws Exception{
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
    }
}
