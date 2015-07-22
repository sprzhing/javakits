/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zhuhongquan on 15/7/20.
 */

@XmlRootElement(name="employee")
public class Employee {

    private long id;
    private String name;
    private String email;

    public Employee() {}

    public Employee(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
