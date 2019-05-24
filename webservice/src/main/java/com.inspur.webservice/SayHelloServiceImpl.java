package com.inspur.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * User: YANG
 * Date: 2019/5/23-10:08
 * Description: No Description
 */
@WebService
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    @WebMethod
    public String sayHello(String name) {
        System.out.println("call sayHello ...");
        return "Hello " + name;
    }
}
