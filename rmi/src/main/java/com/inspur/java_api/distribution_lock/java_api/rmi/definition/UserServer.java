package com.inspur.java_api.distribution_lock.java_api.rmi.definition;

/**
 * User: YANG
 * Date: 2019/5/22-21:58
 * Description: No Description
 */
public class UserServer extends User {

    public static void main(String[] args){

        UserServer userServer = new UserServer();
        userServer.setUsername("zhangsan");

        UserSkeleton userSkeleton = new UserSkeleton(userServer);
        userSkeleton.start();

    }

}
