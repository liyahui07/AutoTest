package com.course.controller;

import io.swagger.annotations.Api;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "/",description = "demo1")
public class Demo1 {
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @GetMapping("/getUserCount")
    public Integer getUserCount(){
        int i = sessionTemplate.selectOne("test1.selectUC");
        return i;
    }
}
