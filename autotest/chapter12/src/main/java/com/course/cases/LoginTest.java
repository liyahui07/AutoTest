package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeTest(groups = "test")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSER);
    }


    @Test(groups = "test")
    public void login_True(){
        SqlSession session = null;
        try {
            session = MybatisUtils.getSqlSession();
            LoginCase loginCase = session.selectOne("loginTrue",1);
            System.out.println(loginCase.toString());
            System.out.println(TestConfig.loginUrl);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSession(session);
        }

    }




}
