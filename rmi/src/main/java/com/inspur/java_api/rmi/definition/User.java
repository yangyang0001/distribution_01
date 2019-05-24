package com.inspur.java_api.rmi.definition;

import java.io.Serializable;

/**
 * User: YANG
 * Date: 2019/5/22-21:54
 * Description: No Description
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8347848775894898815L;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
