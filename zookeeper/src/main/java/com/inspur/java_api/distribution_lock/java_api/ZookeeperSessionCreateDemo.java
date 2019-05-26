package com.inspur.java_api.distribution_lock.java_api;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * User: YANG
 * Date: 2019/5/24-13:50
 * Description: No Description
 * 创建链接的Demo
 */
public class ZookeeperSessionCreateDemo {

    public final static String ZOOKEEPER_CONNECTION_URL =
            "192.168.120.110:2181," +
            "192.168.120.150:2181," +
            "192.168.120.224:2181," +
            "192.168.120.137:2181";

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(ZOOKEEPER_CONNECTION_URL, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if(event.getState() == Event.KeeperState.SyncConnected){
                        System.out.println("eventState:" + event.getState() + ",eventType:" + event.getType());
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            System.out.println(zooKeeper.getState());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
