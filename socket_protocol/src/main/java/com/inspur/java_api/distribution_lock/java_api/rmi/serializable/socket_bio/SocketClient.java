package com.inspur.java_api.distribution_lock.java_api.rmi.serializable.socket_bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: YANG
 * Date: 2019/5/21-22:11
 * Description: No Description
 */
public class SocketClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8888);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println("Hello Server");

            while(true){
                String readLine = bufferedReader.readLine();
                if(readLine == null){
                    break;
                }
                System.out.println(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
