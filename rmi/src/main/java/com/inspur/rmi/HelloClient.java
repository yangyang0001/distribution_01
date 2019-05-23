package com.inspur.rmi;

import java.rmi.Naming;

/**
 * User: YANG
 * Date: 2019/5/22-19:33
 * Description: No Description
 */
public class HelloClient {

    public static void main(String[] args) {
        try {
            SayHelloService sayHelloService = (SayHelloService) Naming.lookup("rmi://localhost:8888/sayHello");
            System.out.println(sayHelloService.sayHello("YangYang"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
