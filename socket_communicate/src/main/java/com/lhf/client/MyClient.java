package com.lhf.client;

import java.io.*;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",8081);

        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        printWriter.println("你好");
        //注意刷缓冲，不然不提交
        printWriter.flush();


        String reply = bufferedReader.readLine();
        System.out.println("人工智能答复："+reply);

    }
}
