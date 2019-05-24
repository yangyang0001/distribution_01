package com.inspur.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * User: YANG
 * Date: 2019/5/24-21:54
 * Description: No Description
 */
public class CuratorClientUtil {

    public final static String ZOOKEEPER_CONNECTION_URL =
            "192.168.120.110:2181," +
                    "192.168.120.150:2181," +
                    "192.168.120.224:2181," +
                    "192.168.120.137:2181";


    public static CuratorFramework getInstance(){
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.newClient(ZOOKEEPER_CONNECTION_URL, 5000, 5000, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        return curatorFramework;
    }

}
