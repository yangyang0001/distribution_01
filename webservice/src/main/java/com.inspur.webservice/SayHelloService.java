package com.inspur.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * User: YANG
 * Date: 2019/5/23-10:06
 * Description: No Description
 */
@WebService
public interface SayHelloService {

    @WebMethod
    public String sayHello(String name);
}
