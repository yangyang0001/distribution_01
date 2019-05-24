package com.inspur.java_api;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * User: YANG
 * Date: 2019/5/24-16:19
 * Description: No Description
 *
 * ACL的使用,就是对ZNode节点数据的操作权限的使用
 * 配合AuthCreateDemo使用
 *
 */
public class AuthDeleteDemo implements Watcher{

    public final static String ZOOKEEPER_CONNECTION_URL =
                    "192.168.120.110:2181," +
                    "192.168.120.150:2181," +
                    "192.168.120.224:2181," +
                    "192.168.120.137:2181";

    public final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            //创建另外一个客户端测试是否能够删除
            ZooKeeper zooKeeper2 = new ZooKeeper(ZOOKEEPER_CONNECTION_URL, 5000, new AuthDeleteDemo());
            zooKeeper2.addAuthInfo("digest", "root:root".getBytes());

            Thread.sleep(3000);
            //删除节点
            zooKeeper2.delete("/Yang02", -1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("eventState  ------------------>:" + event.getState() + ", eventType ------------------>:" + event.getType());
    }
}
