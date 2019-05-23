package com.inspur.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * User: YANG
 * Date: 2019/5/22-19:28
 * Description: No Description
 */
public class HelloServer {

    public static void main(String[] args) {

        try {
            SayHelloService sayHelloService = new SayHelloServiceImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/sayHello", sayHelloService);

            System.out.println("server start success");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

    }
}
