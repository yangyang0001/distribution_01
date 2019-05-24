package com.inspur.java_api;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * User: YANG
 * Date: 2019/5/24-14:05
 * Description: No Description
 * 节点的增删改查的API操作,以及各种在连接成功之后的事件的操作类型EventType都是针对Node的操作!
 */
public class ZookeeperNodeTest implements Watcher{

    public final static String ZOOKEEPER_CONNECTION_URL =
                    "192.168.120.110:2181," +
                    "192.168.120.150:2181," +
                    "192.168.120.224:2181," +
                    "192.168.120.137:2181";

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(ZOOKEEPER_CONNECTION_URL, 5000, new ZookeeperNodeTest());
//            countDownLatch.await();
            System.out.println("zookeeper state :--------------------------------------->" + zooKeeper.getState());

            byte[] bytes = null;
//            //创建节点:
//            zooKeeper.create("/Yang02", "123456".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//            bytes = zooKeeper.getData("/Yang02", new ZookeeperNodeTest(), new Stat());
//            Thread.sleep(2000);
//            System.out.println(new String(bytes));
//
//            //修改节点:
//            zooKeeper.setData("/Yang02", "111".getBytes(), -1);
//            bytes = zooKeeper.getData("/Yang02", new ZookeeperNodeTest(), new Stat());
//            Thread.sleep(2000);
//            System.out.println(new String(bytes));
//
//            //删除节点
//            zooKeeper.delete("/Yang02",  -1);


            //创建节点和子节点
            Thread.sleep(2000);

            zooKeeper.create("/Yang03", "parent".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            bytes = zooKeeper.getData("/Yang03", new ZookeeperNodeTest(), new Stat());
            System.out.println(new String(bytes));

            Thread.sleep(2000);

            zooKeeper.create("/Yang03/Yang03-01", "child".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            bytes = zooKeeper.getData("/Yang03/Yang03-01", new ZookeeperNodeTest(), new Stat());
            System.out.println(new String(bytes));

            Thread.sleep(2000);

            zooKeeper.delete("/Yang03/Yang03-01", -1);
            zooKeeper.delete("/Yang03", -1);


            //获取某个节点下的所有子节点(获取的是直接子节点)
            List<String> childPath = zooKeeper.getChildren("/Yang", true);
            System.out.println(childPath);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("eventState --------->" + event.getState() + ",  eventType --------->" + event.getType());
    }
}
