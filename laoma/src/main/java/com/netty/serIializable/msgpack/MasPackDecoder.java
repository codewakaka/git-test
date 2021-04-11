package com.netty.serIializable.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @ClassName MasPackDecoder
 * @Description: 解码器
 * @Author xgh
 * @Date 2021/4/11
 **/
public class MasPackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf msg, List<Object> list) throws Exception {
        //获得字节的长度
        System.out.println("11111");
        final  int length = msg.readableBytes();
        final byte[] array = new byte[length];
        //将byteBuf内容读取到byte中
        msg.getBytes(msg.readerIndex(),array,0,length);
        MessagePack messagePack = new MessagePack();
        //将内容解码，并放入list中
        list.add(messagePack.read(array,User.class));
    }
}
