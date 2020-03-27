package com.javaweb.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ：xgh
 * @description：
 * @date ：Created in 2019/8/4 20:18
 */
public class MyNio {
    public void selector() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //设置非阻塞方法
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(8080));
        //注册监听事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //获得所有key的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                    //接受到服务端请求
                    SocketChannel sc = ssChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    it.remove();
                } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    SocketChannel sc =(SocketChannel) key.channel();
                    while (true) {
                        buffer.clear();
                        //读数据
                        int n = sc.read(buffer);
                        if (n <= 0) {
                            break;
                        }
                        buffer.flip();
                    }
                    it.remove();
                }
            }
        }

    }
}
