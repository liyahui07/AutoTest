package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

public class AddUserTest {


    @Test(groups = "test")
    public void addUserTest(){
        SqlSession session = null;

        try{
            session = MybatisUtils.getSqlSession();
            AddUserCase addUserCase = session.selectOne("addUserTrue",1);
            System.out.println(addUserCase.toString());
            System.out.println(TestConfig.addUserUrl);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSession(session);
        }

    }
}
