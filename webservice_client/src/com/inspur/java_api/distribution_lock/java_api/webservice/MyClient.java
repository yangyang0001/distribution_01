package com.inspur.java_api.distribution_lock.java_api.webservice;

/**
 * User: YANG
 * Date: 2019/5/23-10:41
 * Description: No Description
 * 原生JDK对WebService中发布的WebService接口 SayHelloService的客户端的调用
 */
public class MyClient {

    public static void main(String[] args){
        SayHelloServiceImplService sayHelloServiceImplService = new SayHelloServiceImplService();
        SayHelloServiceImpl sayHelloService = sayHelloServiceImplService.getSayHelloServiceImplPort();
        String result = sayHelloService.sayHello("张三");
        System.out.println(result);
    }
}
