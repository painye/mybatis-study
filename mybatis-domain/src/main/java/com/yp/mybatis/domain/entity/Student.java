package com.yp.mybatis.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Student")
public class Student {
    private String name;
    private String sno;
    private String sex;
    private String dept;
    private Integer age;
}
