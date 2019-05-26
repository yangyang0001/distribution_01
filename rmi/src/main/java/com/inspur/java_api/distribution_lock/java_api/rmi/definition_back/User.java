package com.inspur.java_api.distribution_lock.java_api.rmi.definition_back;

import java.io.Serializable;

/**
 * User: YANG
 * Date: 2019/5/23-9:09
 * Description: No Description
 */
public class User implements Serializable {
    private static final long serialVersionUID = -4883867608190403460L;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
