package com.lhf.server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在特定端口上等待客户端请求
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        //创建serverSocket对象，注册到固定端口
        ServerSocket server = new ServerSocket(8081);
        //阻塞式等待请求
        Socket socket = server.accept();

        //获取连接的输入输出流
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printWriter = new PrintWriter(outputStream);

        //接受输入缓冲区
        String req = bufferedReader.readLine();
        System.out.println("客户端发来消息："+req);
        String reply = req+"吗？";

        //回复客户端消息
        printWriter.println(reply);
        printWriter.flush();

    }
}
