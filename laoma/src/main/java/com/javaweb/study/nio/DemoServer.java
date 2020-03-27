package com.javaweb.study.nio;

import org.springframework.web.bind.annotation.RequestHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DemoServer extends Thread{
    private ServerSocket serverSocket;
    private int getPort(){
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            Executor executor =Executors.newFixedThreadPool(8);
            while (true){
                Socket socket = serverSocket.accept();
                RequestHandler requestHeader = new RequestHandler(socket);
                //requestHeader.start();
                executor.execute(requestHeader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DemoServer demoServer = new DemoServer();
        demoServer.start();
        try(Socket click = new Socket(InetAddress.getLocalHost(),demoServer.getPort());) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(click.getInputStream()));
            bufferedReader.lines().forEach(s-> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class RequestHandler extends Thread {
    private Socket socket;
    public RequestHandler( Socket socket){
        this.socket =socket;
    }

    @Override
    public void run() {
        try( PrintWriter out = new PrintWriter(socket.getOutputStream());) {
           out.println("");
           out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
