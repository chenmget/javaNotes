package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-01 19:36
 **/
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //对于每个传入的消息都要调用
        ByteBuf in = (ByteBuf) msg;
        System.out.println("server receive :"+in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //通知ChannelInboundHandler最后一次对channel-Read()的调用是当前批量读取中的最后一条消息
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable throwable) throws Exception {
        //在读取操作期间，有异常抛出时会调用。
        throwable.printStackTrace();
        ctx.close();

    }
}
