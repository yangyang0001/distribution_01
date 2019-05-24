package com.inspur.java_api.rmi.definition;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * User: YANG
 * Date: 2019/5/22-21:58
 * Description: No Description
 * 注意点:
 *      Client端写出的东西,在Server端必须要用同样的方法来接收;例如:writeObject 对应 readObject; writeInt() 和 readInt();
 */
public class UserStub{

    private Socket socket;

    public UserStub() {
        try {
            socket = new Socket("localhost", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername(){
        String username = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("username");
            oos.flush();

            ois = new ObjectInputStream(socket.getInputStream());
            username = (String) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return username;
    }
}
