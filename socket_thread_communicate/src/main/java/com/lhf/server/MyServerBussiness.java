package com.lhf.server;

import java.io.*;
import java.net.Socket;

public class MyServerBussiness implements Runnable {

    private Socket socket;

    public MyServerBussiness(Socket socket) {
        this.socket = socket;
    }



    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter printWriter = new PrintWriter(outputStream);
            String message = "";
            while ((message=bufferedReader.readLine())!=null){
                System.out.println("客户端发来消息："+message);
                String reply = message + "吗？";
                printWriter.println(reply);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
