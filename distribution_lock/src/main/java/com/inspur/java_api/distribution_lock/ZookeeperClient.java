package com.inspur.java_api.distribution_lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * User: YANG
 * Date: 2019/5/25-15:05
 * Description: No Description
 */
public class ZookeeperClient {


    public final static String ZOOKEEPER_CONNECTION_URL =
            "192.168.120.110:2181," +
                    "192.168.120.150:2181," +
                    "192.168.120.224:2181," +
                    "192.168.120.137:2181";

    public final static int SESSIONT_IMEOUT = 5000;

    public static ZooKeeper getInstance(){
        ZooKeeper zooKeeper = null;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            zooKeeper = new ZooKeeper(ZOOKEEPER_CONNECTION_URL, SESSIONT_IMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    countDownLatch.countDown();
                    System.out.println("eventType ---------->:" + event.getType());
                }
            });
            countDownLatch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }

}
