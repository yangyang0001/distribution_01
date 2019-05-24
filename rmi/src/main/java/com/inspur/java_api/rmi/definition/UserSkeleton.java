package com.inspur.java_api.rmi.definition;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: YANG
 * Date: 2019/5/22-22:01
 * Description: No Description
 */
public class UserSkeleton extends Thread {

    private UserServer userServer;

    public UserSkeleton(UserServer userServer) {
        this.userServer = userServer;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);

            while(true){
                Socket socket = serverSocket.accept();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String method = (String)ois.readObject();
                System.out.println(method);

                if("username".equals(method)){
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(userServer.getUsername());
                    oos.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }
}
