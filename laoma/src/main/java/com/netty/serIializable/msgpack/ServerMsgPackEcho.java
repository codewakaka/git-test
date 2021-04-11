package com.netty.serIializable.msgpack;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.net.InetSocketAddress;

/**
 * @ClassName ServerMsgpPackEcho
 * @Description:
 * @Author xgh
 * @Date 2021/4/11
 **/
public class ServerMsgPackEcho {

    public  static final int PORT = 10995;

    public static void main(String[] args) throws Exception {
        ServerMsgPackEcho serverMsgPackEcho = new ServerMsgPackEcho();
        System.out.println("服务器即将启动");
        serverMsgPackEcho.start();
    }

    public void  start()throws Exception{
        final MsgPackServerHandler serverHandler = new MsgPackServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();

        try{
            //服务器启动必备
            ServerBootstrap bootstrap =new ServerBootstrap();
            //将线程组传入
            bootstrap.group(group)
                     //指定使用NIO进行网络传输
                     .channel(NioServerSocketChannel.class)
                     //指定服务器监听端口
                     .localAddress(new InetSocketAddress(PORT))
                     //服务端没接受到一个连接请求，就会新启一个socket通信也就是channel
                     //下面代码作用就是为这个channel增加handler
                     .childHandler(new ChannelInitializerImp());
            ChannelFuture f = bootstrap.bind().sync();
            System.out.println("服务器启动完毕1等待客户端连接");
            //阻塞直到服务器channel关闭
            f.channel().closeFuture().sync();
        }finally {
            //关闭线程组
            group.shutdownGracefully().sync();
        }

    }

    private static class ChannelInitializerImp extends ChannelInitializer<Channel>{

        @Override
        protected void initChannel(Channel ch) throws Exception {
            //粘包拆包
            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535,
                    0,2,0,2));
            //添加解码器
            ch.pipeline().addLast(new MasPackDecoder());
            //业务处理
            ch.pipeline().addLast(new MsgPackServerHandler());
        }
    }
}
