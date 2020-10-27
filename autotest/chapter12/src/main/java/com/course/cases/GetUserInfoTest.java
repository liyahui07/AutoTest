package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

public class GetUserInfoTest {


    @Test(groups = "test")
    public void testGetUserInfo(){
        SqlSession session = null;

        try{
            session = MybatisUtils.getSqlSession();
            GetUserListCase getUserListCase = session.selectOne("getUserList",1);
            System.out.println(getUserListCase.toString());
            System.out.println(TestConfig.getUserListUrl);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSession(session);
        }
    }
}
