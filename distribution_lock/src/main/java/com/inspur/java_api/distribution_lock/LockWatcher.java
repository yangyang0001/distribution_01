package com.inspur.java_api.distribution_lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * User: YANG
 * Date: 2019/5/25-15:29
 * Description: No Description
 */
public class LockWatcher implements Watcher {

    private CountDownLatch countDownLatch;

    public LockWatcher(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent event) {
        countDownLatch.countDown();
    }
}
