package com.course.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isdelete;
    private String expected;

}
