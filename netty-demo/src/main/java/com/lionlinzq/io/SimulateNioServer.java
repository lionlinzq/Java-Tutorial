package com.lionlinzq.io;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟nio服务器
 *
 * @author lionlinzq
 * @date 2023/8/1 14:13
 */
@Slf4j
public class SimulateNioServer {
    public static void main(String[] args) throws InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        List<SocketChannel> socketChannelList = new ArrayList<>();
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(10086));
            // 设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            log.debug("服务器启动, 监听端口:{}等待客户端连接", 10086);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    log.debug("socket为空,正在等待连接中...");
                    Thread.sleep(5000);
                } else {
                    log.info("当前接收到一个客户端连接, 客户端地址:{}", socketChannel);
                    socketChannelList.add(socketChannel);
                }

                for (SocketChannel socket : socketChannelList) {
                    socket.configureBlocking(false);
                    int effective = socket.read(byteBuffer);
                    if (effective != 0) {
                        byteBuffer.flip();// 切换模式  写-->读
                        String content = StandardCharsets.UTF_8.decode(byteBuffer).toString();
                        log.info("接收到消息:" + content);
                        byteBuffer.clear();
                    } else {
                        log.debug("当前未收到客户端消息");
                    }
                }
            }
        } catch (IOException e) {
           log.error("出现异常,请检查...", e);
        }
    }
}
