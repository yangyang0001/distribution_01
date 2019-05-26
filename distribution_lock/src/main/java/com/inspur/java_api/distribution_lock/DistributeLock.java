package com.inspur.java_api.distribution_lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * User: YANG
 * Date: 2019/5/25-15:12
 * Description: No Description
 */
public class DistributeLock {

    public static final String ROOT_PATH = "/ROOT_LOCK";
    public static final ZooKeeper zooKeeper = ZookeeperClient.getInstance();
    private String lockID;

    public boolean lock() throws KeeperException, InterruptedException {

        lockID = zooKeeper.create(ROOT_PATH + "/", "root_lock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        List<String> allLockIds = zooKeeper.getChildren(ROOT_PATH, true);
        SortedSet<String> sortedLockSet = new TreeSet<String>();
        for(String lockid : allLockIds){
            sortedLockSet.add(ROOT_PATH + "/" + lockid);
        }

        String firstLock = sortedLockSet.first();
        if(lockID.equals(firstLock) ){
            System.out.println(Thread.currentThread().getName() + " 拿到锁[" + lockID + "]");
            return true;
        } else {
            SortedSet<String> prevLocks = sortedLockSet.headSet(lockID);
            if(prevLocks != null){
                String prevLock = prevLocks.last();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                zooKeeper.exists(prevLock, new LockWatcher(countDownLatch));
                countDownLatch.await(ZookeeperClient.SESSIONT_IMEOUT, TimeUnit.MICROSECONDS);
                System.out.println(Thread.currentThread().getName() + " 拿到锁[" + lockID + "]");
            }
            return true;
        }
    }

    public boolean unlock(){
        try {
            zooKeeper.delete(lockID, -1);
            System.out.println(Thread.currentThread().getName() + " 开始释放锁,节点["+lockID+"]成功被删除");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Random random=new Random();
        try {
            for(int i = 0; i < 10; i++){
                new Thread(() -> {
                    DistributeLock distributeLock = new DistributeLock();
                    try {
                        countDownLatch.countDown();
                        countDownLatch.await();
                        distributeLock.lock();
                        Thread.sleep(random.nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } finally {
                        distributeLock.unlock();
                    }
                }).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }





    }
}
