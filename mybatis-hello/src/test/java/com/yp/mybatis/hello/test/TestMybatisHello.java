package com.yp.mybatis.hello.test;


import com.yp.mybatis.domain.entity.Student;
import com.yp.mybatis.hello.mapper.IStudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class TestMybatisHello {

    private SqlSession sqlSession;
    private static SqlSessionFactory sqlSessionFactory;
    private static Scanner sc;

    static {
        sc=new Scanner(System.in);
        init();
    }

    private static void init(){
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build( Resources.getResourceAsReader("mybatis-configuration.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * //读取配置文件 mybatis-configuration.xml
     *         //Reader reader = Resources.getResourceAsReader("mybatis-configuration.xml");
     *         //SqlSessionFactory工厂
     *         //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
     */
    public void testSave() throws Exception{
        //sqlSession
        sqlSession=sqlSessionFactory.openSession();
        //绑定接口
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);//代理模式
        mapper.save(new Student("唐迟", "201215002", "男", "SD", 23));
    }

    @Test
    public void testFindAll() throws Exception{
        sqlSession = sqlSessionFactory.openSession();
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        List<Student> list = mapper.findAll();
        System.out.println(list);

    }

    @Test
    public void testDelete(){
        sqlSession = sqlSessionFactory.openSession();
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        mapper.delete("123123");
    }

    @Test
    public void testUpdate(){
        sqlSession = sqlSessionFactory.openSession();
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        mapper.update(new Student(null, "201215000", null, "MT", 70));
    }

    @After
    public void finish(){
        sqlSession.commit();//事物的提交
        sqlSession.close();
    }

}
