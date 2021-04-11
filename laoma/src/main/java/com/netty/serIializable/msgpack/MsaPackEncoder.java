package com.netty.serIializable.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @ClassName MsaPackEncode
 * @Description:
 * @Author xgh
 * @Date 2021/4/11
 **/
public class MsaPackEncoder  extends MessageToByteEncoder<User> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, User user, ByteBuf byteBuf) throws Exception {
        MessagePack messagePack = new MessagePack();
        byte[] raw = messagePack.write(user);
        byteBuf.writeBytes(raw);

    }
}
