/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * Created by zhuhongquan on 15/7/20.
 */
@Service
public class EmployeeDS {

    private static Map<Long, Employee> allEmployees;
    static {
        allEmployees = new HashMap<Long, Employee>();
        Employee e1 = new Employee(1L, "zhuhongquan", "zhuhongquan@baidu.com");
        Employee e2 = new Employee(2L, "liyuanhang", "liyuanhang@baidu.com");
        Employee e3 = new Employee(3L, "yuzhiyuan", "yuzhiyuang@baidu.com");
        allEmployees.put(e1.getId(), e1);
        allEmployees.put(e2.getId(), e2);
        allEmployees.put(e3.getId(), e3);
    }

    public void add(Employee e) {
        allEmployees.put(e.getId(), e);
    }

    public Employee get(long id) {
        return allEmployees.get(id);
    }

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<Employee>();
        for( Iterator<Employee> it = allEmployees.values().iterator(); it.hasNext(); ) {
            Employee e = it.next();
            employees.add(e);
        }
        return employees;
    }

    public void remove(long id) {
        allEmployees.remove(id);
    }

    public void update(Employee e) {
        allEmployees.put(e.getId(), e);
    }

}

