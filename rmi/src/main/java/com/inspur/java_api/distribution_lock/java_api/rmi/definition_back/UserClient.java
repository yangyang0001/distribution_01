package com.inspur.java_api.distribution_lock.java_api.rmi.definition_back;

/**
 * User: YANG
 * Date: 2019/5/23-9:27
 * Description: No Description
 */
public class UserClient {

    public static void main(String[] args){
        UserStub userStub = new UserStub();
        System.out.println(userStub.getUserName("username"));
    }
}
