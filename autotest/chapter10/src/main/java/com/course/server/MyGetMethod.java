package com.course.server;


import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetMethod {

    @GetMapping("/get/cookies")
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "test");
        response.addCookie(cookie);
        return "恭喜你获得cookies";
    }

    @GetMapping("/getWithCookies")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你的cookies为空";
        }

        for (Cookie c :
                cookies) {
            if (c.getName().equals("login") && c.getValue().equals("test")) {
                return "恭喜你访问成功";
            }
        }
        return "你需要携带COOKIES才能访问";
    }

    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> map = new HashMap<>();
        map.put("鞋子",200);
        map.put("衣服",300);
        map.put("裤子",400);

        if (start < 200){

        }

        return map;
    }
}
