package com.lhf.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class MyServer {

    public static void main(String[] args) throws IOException {
        //构造一个线程池
        int corePoolSize = 1;
        int maxinumPoolSize = 5;
        long keepAliveTime = 1000L;
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(30);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maxinumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("socket_thread_communicate_"+t.getName());
                return t;
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("队列里放不下了，线程数量超越了maxinumPoolSize...拒绝此任务");
                // throws Exception()...
            }
        });

        ServerSocket server = new ServerSocket(8080);

        //服务端一直阻塞，有req就直接用线程处理
        while (true){
            Socket socket = server.accept();
            pool.submit(new MyServerBussiness(socket));
        }

    }
}
