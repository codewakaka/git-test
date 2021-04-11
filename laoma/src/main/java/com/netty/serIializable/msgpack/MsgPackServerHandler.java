package com.netty.serIializable.msgpack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MsgPackServerHandler
 * @Description: 服务端出来业务
 * @Author xgh
 * @Date 2021/4/11
 **/
public class MsgPackServerHandler extends ChannelInboundHandlerAdapter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //将上一个handler生成的数据进行强制转型
        User user = (User) msg;
        System.out.println("server accept["+user+"]and the count is:"+atomicInteger.incrementAndGet());
        //服务器应答
        String resp ="I process user :"+ user.getUsername() +System.getProperty("line.separator");
        ctx.writeAndFlush(resp);
        //将消息传到下一个channel
        ctx.fireChannelRead(user);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
