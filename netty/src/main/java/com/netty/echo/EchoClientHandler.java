package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-02 19:04
 **/
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //在到服务器的连接已经建立之后将被调用
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        //当从服务器接收到一条消息时被调用
        System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8));
    }

    @Override
    public  void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        //在处理过程中引发异常时被调用
        cause.printStackTrace();
        ctx.close();
    }
}
