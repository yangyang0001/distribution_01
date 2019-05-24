package com.inspur.webservice;

import javax.xml.ws.Endpoint;

/**
 * User: YANG
 * Date: 2019/5/23-10:09
 * Description: No Description
 */
public class Bootstrap {

    public static void main(String[] args){
        SayHelloService sayHelloService = new SayHelloServiceImpl();
        //发布Endpoint
        Endpoint.publish("http://localhost:8888/sayHelloService", sayHelloService);
    }
}
