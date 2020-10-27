package com.course.controller;


import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j
@RestController
@Api(value = "/",description = "userManager interface")
public class UserManager {
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @PostMapping("/login")
    @ApiOperation(value = "login",httpMethod = "POST")
    public Boolean login(HttpServletResponse response,@RequestBody User user){
        int i = sessionTemplate.selectOne("login",user);
        if (i == 1){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
            log.info("登录成功，获取cookies成功");
            return true;
        }
        log.info("用户名或者密码错误");
        return false;
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "insert User Data",httpMethod = "POST")
    public Boolean addUser(HttpServletRequest request,@RequestBody User user){
        boolean flag = verifyCookies(request);
        if (!flag){
            log.info("cookies verify fail");
            return false;
        }
        int i = sessionTemplate.insert("addUser",user);
        if (i == 1){
            log.info("新增的用户数量:" + i);
            return true;
        }
        log.info("新增用户失败");
        return false;
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "update USER INFO",httpMethod = "POST")
    public Integer updateUser(HttpServletRequest request,@RequestBody User user){
        Boolean flag = verifyCookies(request);
        if (!flag){
            log.info("cookies verify fail");
            return null;
        }
        int i = sessionTemplate.update("",user);
        log.info("更新用户的数量为:" + i);
        return i;

    }

    @PostMapping("/getUserList")
    @ApiOperation(value = "get USER LIST",httpMethod = "POST")
    public List<User> getUserList(HttpServletRequest request,@RequestBody User user){
        Boolean flag = verifyCookies(request);
        if (!flag){
            log.info("cookies verify fail");
            return null;
        }
        List<User> list = sessionTemplate.selectList("selectUserList",user);
        return list;
    }

    /**
     *  验证cookies的方法
     * @param request 请求中传入参数用于验证cookies
     * @return
     */
    public Boolean verifyCookies(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return false;
        }

        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals(true)){
                return true;
            }
        }
        return false;
    }


}
