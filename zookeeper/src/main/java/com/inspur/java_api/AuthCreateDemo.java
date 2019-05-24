package com.inspur.java_api;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.List;

/**
 * User: YANG
 * Date: 2019/5/24-16:19
 * Description: No Description
 *
 * ACL的使用,就是对ZNode节点数据的操作权限的使用
 * 配合AuthDeleteDemo使用
 */
public class AuthCreateDemo implements Watcher{

    public final static String ZOOKEEPER_CONNECTION_URL =
                    "192.168.120.110:2181," +
                    "192.168.120.150:2181," +
                    "192.168.120.224:2181," +
                    "192.168.120.137:2181";

    public static void main(String[] args) {
        try {
            //ACL权限包括四种:ip, digest, world, super
            ACL acl1=new ACL(ZooDefs.Perms.ALL, new Id("Digest","root:root"));
//            ACL acl2=new ACL(ZooDefs.Perms.CREATE, new Id("ip","192.168.120.110"));

            List<ACL> acls = new ArrayList<ACL>();
            acls.add(acl1);
//            acls.add(acl2);

            ZooKeeper zooKeeper = new ZooKeeper(ZOOKEEPER_CONNECTION_URL, 5000, new AuthCreateDemo());
            System.out.println("zookeeper state :--------------------------------------->" + zooKeeper.getState());
            zooKeeper.addAuthInfo("Digest", "root:root".getBytes());

            byte[] bytes = null;
            //创建节点:
            zooKeeper.create("/Yang02", "123456".getBytes(), acls, CreateMode.PERSISTENT);
            bytes = zooKeeper.getData("/Yang02", new AuthCreateDemo(), new Stat());
            System.out.println(new String(bytes));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("eventState  ------------------>:" + event.getState() + ", eventType ------------------>:" + event.getType());
    }
}
