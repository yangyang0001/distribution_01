package com.inspur.curator;

import org.apache.curator.framework.CuratorFramework;

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
        curatorFramework.create().creatingParentsIfNeeded().forPath("/curator", "curator".getBytes());





    }
}
