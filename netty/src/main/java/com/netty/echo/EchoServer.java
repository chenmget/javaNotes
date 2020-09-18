package com.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

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
        new EchoServer(8082).start();
    }

    private void start() throws Exception{
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            // 基于指定字符串【换行符，这样功能等同于LineBasedFrameDecoder】
                            // e.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter()));
                            // 基于最大长度
                            // e.pipeline().addLast(new FixedLengthFrameDecoder(4));
                            // 解码转String，注意调整自己的编码格式GBK、UTF-8
                            ch.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
                            ch.pipeline().addLast(serverHandler);
                        }
                    });
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }


    }
}
