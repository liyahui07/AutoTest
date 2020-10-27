package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserCase;
import com.course.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

public class UpdateUserTest {


    @Test(groups = "test")
    public void testUpdateUserName(){
        SqlSession session = null;

        try{
            session = MybatisUtils.getSqlSession();
            UpdateUserCase updateUserCase = session.selectOne("updateUserName",1);
            System.out.println(updateUserCase.toString());
            System.out.println(TestConfig.updateUserUrl);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSession(session);
        }
    }
}
