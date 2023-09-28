package com.lionlinzq.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {
    public static void main(String[] args) throws IOException {
        Selector selector = null;
        // try {
        //     selector = Selector.open();
        //     ServerSocketChannel channel = ServerSocketChannel.open();
        //     channel.configureBlocking(false);
        //     channel.bind(new InetSocketAddress(8000));
        //     channel.register(selector, SelectionKey.OP_ACCEPT);
        //     while (true) {
        //         selector.select();
        //         for (SelectionKey key : selector.selectedKeys()) {
        //             selector.selectedKeys().remove(key);
        //             if (key.isValid() && key.isAcceptable()) {
        //                 handleAccept(selector, key);
        //             }
        //         }
        // }
    }


    private static void handleAccept(Selector selector, SelectionKey key) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel client = channel.accept();
        if (client != null) {
            try {
                client.configureBlocking(false);
                client.register(selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
