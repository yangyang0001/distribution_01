package com.inspur.java_api.distribution_lock.java_api.rmi.definition_back;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: YANG
 * Date: 2019/5/23-9:10
 * Description: No Description
 * 本程序模仿服务端Skeleton接收到客户端的请求,根据请求返回一个数据
 *
 */
public class UserSkeleton extends Thread{

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
                String method = (String) ois.readObject();

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
