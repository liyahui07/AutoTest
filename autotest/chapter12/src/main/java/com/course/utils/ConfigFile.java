package com.course.utils;

import com.course.model.InterfaceName;

import java.util.ResourceBundle;

public class ConfigFile {

    public static ResourceBundle bundlel;

    public static String getUrl(InterfaceName interfaceName){
        bundlel = ResourceBundle.getBundle("application");
        String url = bundlel.getString("test.url");
        String uri = "";

        if (interfaceName == InterfaceName.LOGIN){
            uri = bundlel.getString("login.uri");
        }

        if (interfaceName == InterfaceName.ADDUSER){
            uri = bundlel.getString("addUser.uri");
        }

        if (interfaceName == InterfaceName.GETUSERLIST){
            uri = bundlel.getString("getUserList.uri");
        }

        if (interfaceName == InterfaceName.UPDATEUSER){
            uri = bundlel.getString("updateUser.uri");
        }
        String testUrl = url + uri;

        return testUrl;
    }
}
