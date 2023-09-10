package com.lzq.grammer.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * 套接字测试
 *
 * @author lin
 * @date 2023/08/20
 */
@Slf4j

public class SocketTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String url = "www.baidu.com";
        // 根据域名来进行网络连接，并且在日志中输出域名网址对应的实际的ip地址和端口号
        Socket socket = new Socket(url, 80);


 }
}
