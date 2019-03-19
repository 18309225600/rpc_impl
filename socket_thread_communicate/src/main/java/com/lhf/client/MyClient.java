package com.lhf.client;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket client = new Socket("127.0.0.1",8080);

        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printWriter = new PrintWriter(outputStream);

        String message = "你好";
        printWriter.println(message);
        printWriter.flush();

        String reply = bufferedReader.readLine();
        System.out.println("人工智能回复："+reply);
        Thread.sleep(Long.MAX_VALUE);
    }
}
