package com.course.controller;

import io.swagger.annotations.Api;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/insertUSER")
    public String insertUser(){
        int i = sessionTemplate.insert("insertUSER");
        return "插入用户的数量：" + i;
    }


    @PostMapping("/updateUser")
    public String updateUser(){
        int i = sessionTemplate.update("updateUser");
        return "更新用户的数量为:" + i;
    }
    @PostMapping("/deleteUser")
    public String deleteUser(){
        int i  = sessionTemplate.delete("deleteUser");
        if (i == 1){
            return "删除用户成功";

        }
        return "删除用户失败";
    }
}
