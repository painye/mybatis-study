package com.yp.mybatis.druid.mapper;

import com.yp.mybatis.domain.entity.Student;

import java.util.List;

public interface IStudentMapper {
    List<Student> findAll();
}
