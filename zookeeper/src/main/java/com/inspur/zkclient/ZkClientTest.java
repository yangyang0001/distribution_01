package com.inspur.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * User: YANG
 * Date: 2019/5/24-18:39
 * Description: No Description
 * 因为原生的zookeeper的API太难使用,所以就有人引入了封装的zkClient,本类主要介绍zkClient的使用方式
 */
public class ZkClientTest {

    public final static String ZOOKEEPER_CONNECTION_URL =
            "192.168.120.110:2181," +
                    "192.168.120.150:2181," +
                    "192.168.120.224:2181," +
                    "192.168.120.137:2181";


    public static void main(String[] args){

        ZkClient zkClient = new ZkClient(ZOOKEEPER_CONNECTION_URL, 5000);

//        //节点的添加
//        zkClient.create("/zhangsan", "zhangsan", CreateMode.PERSISTENT);
//        //节点值的读取
//        Object data = zkClient.readData("/zhangsan");
//        System.out.println("zhangsan value --------->:" + data);
//
//        //递归添加节点
//        zkClient.createPersistent("/parent/child", true);
//        //节点值的设置与修改
//        zkClient.writeData("/parent/child", "child");
//        //节点的获取
//        Object object = zkClient.readData("/parent/child");
//        System.out.println("/parent/child value----->:" + object);

        //节点的删除-->递归删除
        zkClient.deleteRecursive("/parent");
        zkClient.deleteRecursive("/zhangsan");

    }

}
