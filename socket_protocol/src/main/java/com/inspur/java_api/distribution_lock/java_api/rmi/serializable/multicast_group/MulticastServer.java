package com.inspur.java_api.distribution_lock.java_api.rmi.serializable.multicast_group;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

/**
 * User: YANG
 * Date: 2019/5/22-9:04
 * Description: No Description
 */
public class MulticastServer {

    public static void main(String[] args){

        try {
            InetAddress group = InetAddress.getByName("224.5.6.7");
            MulticastSocket socket = new MulticastSocket();

            while(true){

                String data = "Hello Clients";
                byte[] bytes = data.getBytes();

                socket.send(new DatagramPacket(bytes, bytes.length, group, 8888));
                TimeUnit.SECONDS.sleep(2);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }


    }
}
