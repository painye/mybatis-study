package com.yp.mybatis.druid.test;

import com.yp.mybatis.domain.entity.Student;
import com.yp.mybatis.druid.mapper.IStudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestMybatis {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;

    static{
        init();
    }

    private static void init(){
        try {
            //创建一个工厂，该工厂由builder类的build方法创建，需要传入参数reader
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-configuration.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() throws Exception{
        sqlSession=sqlSessionFactory.openSession();
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        List<Student> list = mapper.findAll();
        Logger.getLogger(this.getClass()).debug(list);
    }

    @After
    public void finish(){
        sqlSession.commit();
        sqlSession.close();

    }
}
