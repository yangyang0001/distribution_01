package com.inspur.java_api.distribution_lock.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

/**
 * User: YANG
 * Date: 2019/5/24-21:58
 * Description: No Description
 */
public class CuratorOperatorTest {

    public static void main(String[] args) throws Exception{
        CuratorFramework curatorFramework = CuratorClientUtil.getInstance();

        /**
         * 创建节点
         */
        String nodePath = curatorFramework.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/curator", "curator".getBytes());

//        /**
//         * 获取节点的值
//         */
//        Stat nodeStatus = new Stat();
//        byte[] bytes = curatorFramework.getData().storingStatIn(nodeStatus).forPath("/curator");
//        System.out.println("节点的内容 -------->:" + new String(bytes) + ", nodeStat -------->:" + nodeStatus);

//        /**
//         * 更新节点的值
//         */
//        Stat stat = curatorFramework.setData().forPath("/curator", "Yang".getBytes());
//        System.out.println(new String(curatorFramework.getData().forPath("/curator")));
//
//        /**
//         * 异步操作
//         */
//        final ExecutorService executorService = Executors.newSingleThreadExecutor();
//        final CountDownLatch countDownLatch = new CountDownLatch(1);
//        curatorFramework.create().withMode(CreateMode.PERSISTENT).inBackground(new BackgroundCallback() {
//            @Override
//            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
//                System.out.println("当前线程:" + Thread.currentThread().getName() + ", eventType:" + event.getType());
//                countDownLatch.countDown();
//            }
//        }, executorService).forPath("/yang", "yang".getBytes());
//
//        countDownLatch.await();
//        executorService.shutdown();
//
        /**
         * curator中独有的事务操作
         */
//        Collection<CuratorTransactionResult> curatorTransactionResults =
//                curatorFramework.inTransaction()
//                                .create().withMode(CreateMode.PERSISTENT).forPath("/trans", "trans".getBytes())
//                                .and()
//                                .setData().forPath("/yang", "yang_transaction".getBytes())
//                                .and()
//                                .commit();
//
//        for(CuratorTransactionResult result : curatorTransactionResults){
//            System.out.println("transactionForPath -------->:" + result.getForPath() + ", transactionType -------->:" + result.getType());
//        }


    }
}
