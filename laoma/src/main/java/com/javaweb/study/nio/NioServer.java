package com.javaweb.study.nio;
import	java.nio.charset.Charset;
import	java.nio.channels.SelectionKey;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer extends Thread {
    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(),8888));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector,SelectionKey.OP_ACCEPT);
            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    sayHelloWord((ServerSocketChannel) key.channel());
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sayHelloWord(ServerSocketChannel server){
        try {
            SocketChannel click = server.accept();
            click.write(Charset.defaultCharset().encode("hello word"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
