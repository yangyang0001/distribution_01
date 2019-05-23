package com.inspur.rmi.serializable.multicast_group;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * User: YANG
 * Date: 2019/5/22-9:28
 * Description: No Description
 */
public class MulticastClient {

    public static void main(String[] args){

        try {
            InetAddress group = InetAddress.getByName("224.5.6.7");
            MulticastSocket socket = new MulticastSocket(8888);

            socket.joinGroup(group);
            byte[] bytes = new byte[256];

            while(true){
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                socket.receive(datagramPacket);
                String receiveMessage = new String(datagramPacket.getData(), datagramPacket.getData().length);
                System.out.println(receiveMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
