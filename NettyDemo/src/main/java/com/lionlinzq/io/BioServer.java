package com.lionlinzq.io;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio服务器
 *
 * @author lionlinzq
 * @date 2023/8/1 10:35
 */
@Slf4j
public class BioServer {

    @SuppressWarnings("resource")
    // 使用bio实现一个服务器，可以接受 客户端的连接
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(10086);
        log.debug("服务器启动, 监听端口:{}等待客户端连接", 10086);
        while (true) {
            // 获取一个套接字连接
            final Socket socket = serverSocket.accept();
            log.debug("接收到一个客户端连接, 客户端地址:{}", socket);
            new Thread(() -> {
                log.info("服务器接受到信息 ...");
                try {
                    handler(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }

    public static void handler(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();

        while (true) {
            int len = inputStream.read(bytes);
            if (len == -1) {
                break;
            }
            log.info("收到来至{}客户端的数据,信息为:{}", socket, new String(bytes, 0, len));
        }
        socket.close();
        log.debug("socket 已经关闭");
    }
}
