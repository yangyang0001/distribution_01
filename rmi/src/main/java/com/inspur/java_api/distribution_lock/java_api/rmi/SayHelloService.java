package com.inspur.java_api.distribution_lock.java_api.rmi;

import java.rmi.Remote;

/**
 * User: YANG
 * Date: 2019/5/22-19:23
 * Description: No Description
 * 实现RMI的过程!
 * 1.首先创建远程调用的接口 要继承 Remote SayHelloService
 * 2.实现这个远程接口的一个实现类 SayHelloServiceImpl, 并且要继承 UnicastRemoteObject 类
 * 3.创建服务端 HelloServer
 * 4.创建客户端程序
 */
public interface SayHelloService extends Remote{

    public String sayHello(String name) throws Exception;
}
