package com.yp.mybatis.hello.mapper;

import com.yp.mybatis.domain.entity.Student;

import java.util.List;

/**
 * 定义数据访问，类似于dao
 */
public interface IStudentMapper {
    void save(Student stu);
    void delete(String sno);
    void update(Student stu);
    List<Student> findAll();
}
