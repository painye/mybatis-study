package com.yp.mybatis.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private String sno;
    private String sex;
    private String dept;
    private Integer age;
}
