package com.inspur.java_api.rmi.definition_back;

/**
 * User: YANG
 * Date: 2019/5/23-9:11
 * Description: No Description
 */
public class UserServer extends User {

    public static void main(String[] args){
        UserServer userServer = new UserServer();
        userServer.setUsername("YangYangYang");

        UserSkeleton userSkeleton = new UserSkeleton(userServer);
        userSkeleton.start();
    }


}
