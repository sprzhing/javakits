/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuhongquan on 15/7/22.
 */
@Controller
public class DefaultController {
    @RequestMapping("/")
    @ResponseBody
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
