package com.inspur.java_api.distribution_lock.java_api.rmi.definition;

/**
 * User: YANG
 * Date: 2019/5/22-22:01
 * Description: No Description
 */
public class UserClient {

    public static void main(String[] args){
        UserStub stub = new UserStub();
        System.out.println(stub.getUsername());
    }

}
