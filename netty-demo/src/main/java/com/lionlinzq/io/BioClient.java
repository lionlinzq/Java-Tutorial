package com.lionlinzq.io;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * bio客户端
 *
 * @author lionlinzq
 * @date 2023/8/1 10:44
 */
@Slf4j
public class BioClient {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10086);

        String message = null;
        Scanner sc = new Scanner(System.in);
        while (!"q".equals(message)) {
            message = sc.next();
            socket.getOutputStream().write(message.getBytes());
        }
        socket.close();
    }
}
