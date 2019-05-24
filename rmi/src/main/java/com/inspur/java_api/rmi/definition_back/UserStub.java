package com.inspur.java_api.rmi.definition_back;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * User: YANG
 * Date: 2019/5/23-9:27
 * Description: No Description
 */
public class UserStub {

    private Socket socket = null;

    public UserStub() {
        try {
            socket = new Socket("localhost", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserName(String name){
        String result = null;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("username");
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            result = (String) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
