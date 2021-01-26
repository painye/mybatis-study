package com.yp.mybatis.hello.test;


import com.yp.mybatis.domain.entity.Student;
import com.yp.mybatis.hello.mapper.IStudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;

public class TestMybatisHello {
    @Test
    public void testSave() throws Exception{
        //读取配置文件 mybatis-configuration.xml
        Reader reader = Resources.getResourceAsReader("mybatis-configuration.xml");
        //SqlSessionFactory工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //sqlSession
        SqlSession sqlSession=sessionFactory.openSession();

        //绑定接口
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);//代理模式

        mapper.save(new Student("汤家凤", "201215000", "男", "SD", 23));

        sqlSession.commit();//事物的提交
        sqlSession.close();
    }

}
