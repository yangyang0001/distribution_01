package com.inspur.java_api.distribution_lock.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * User: YANG
 * Date: 2019/5/24-18:56
 * Description: No Description
 * curator提供两种创建 链接的方式
 * newClient的重载的方法!
 */
public class CuratorSessionDemo {

    public final static String ZOOKEEPER_CONNECTION_URL =
            "192.168.120.110:2181," +
                    "192.168.120.150:2181," +
                    "192.168.120.224:2181," +
                    "192.168.120.137:2181";

    public static void main(String[] args){

        //第一种创建链接的方式
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.newClient(ZOOKEEPER_CONNECTION_URL, 5000, 5000, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();

        //第二种创建链接的方式
        CuratorFramework curatorFramework1 =
                CuratorFrameworkFactory.builder().connectString(ZOOKEEPER_CONNECTION_URL).sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

        System.out.println("suceess");
    }
}
