package com.netty.serIializable.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MsgPackClientHandler
 * @Description:
 * @Author xgh
 * @Date 2021/4/11
 **/
public class MsgPackClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private final int sendNum;

    public MsgPackClientHandler(int sendNum){
        this.sendNum = sendNum;
    }

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        //客户端读取到网络数据后
        System.out.println("client accept["+msg.toString(CharsetUtil.UTF_8)
        +"] and the count is:" +atomicInteger.incrementAndGet());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端激活以后
        User[] users = makeUsers();
        for (User user : users) {
            System.out.println("send "+ user);
            ctx.write(user);
        }
        ctx.flush();
    }

    private User[] makeUsers(){
        User[] users = new User[sendNum];
        User user = null;
        for (int i=0; i< sendNum;i++){
            user = new User();
            user.setAge(i);
            user.setUsername("ABBSC-->"+i);
            user.setId("NO"+i );
            user.setUserContact(new UserContact("12321"+i,"123"));
            users[i] = user;
        }
        return users;
    }
}
