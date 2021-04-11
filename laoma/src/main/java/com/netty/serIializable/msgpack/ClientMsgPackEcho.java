package com.netty.serIializable.msgpack;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;

/**
 * @ClassName ClientMsgPackEcho
 * @Description:
 * @Author xgh
 * @Date 2021/4/11
 **/
public class ClientMsgPackEcho {
    private final String host;

    public ClientMsgPackEcho(String host) {
        this.host = host;
    }

    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                     .channel(NioSocketChannel.class)
                     .remoteAddress(new InetSocketAddress(host,ServerMsgPackEcho.PORT))
                     .handler(new ChannelInitializerImpl());
            ChannelFuture f = bootstrap.connect().sync();
            System.out.println("已经连接到服务器。。。。");
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }

    }
    private  static class ChannelInitializerImpl extends ChannelInitializer<Channel>{

        @Override
        protected void initChannel(Channel ch) throws Exception {
            ch.pipeline().addLast(new LengthFieldPrepender(2));
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new MsaPackEncoder());
            ch.pipeline().addLast(new MsgPackClientHandler(5));
        }
    }

    public static void main(String[] args) throws Exception {

        new ClientMsgPackEcho("127.0.0.1").start();
    }


}
