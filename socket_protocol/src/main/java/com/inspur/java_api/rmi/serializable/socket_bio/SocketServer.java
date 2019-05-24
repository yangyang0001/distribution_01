package com.inspur.java_api.rmi.serializable.socket_bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: YANG
 * Date: 2019/5/21-22:07
 * Description: No Description
 */
public class SocketServer {

    public static void main(String[] args){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                new Thread(() -> {
                    try {
                        while(true){
                            String readLine = reader.readLine();
                            if(readLine == null){
                                break;
                            }
                            System.out.println("来自客户端的消息:" + readLine);
                            writer.println("Hello Client");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {

                    }
                }).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

    }
}
