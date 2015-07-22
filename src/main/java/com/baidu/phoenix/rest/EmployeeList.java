/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zhuhongquan on 15/7/20.
 */
@XmlRootElement(name="employees")
public class EmployeeList {


    private int count;
    private List<Employee> employees;

    public EmployeeList() {}

    public EmployeeList(List<Employee> employees) {
        this.employees = employees;
        this.count = employees.size();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlElement(name="employee")
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
