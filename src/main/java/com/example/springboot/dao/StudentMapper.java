package com.example.springboot.dao;

import com.example.springboot.entity.Student;
import com.example.springboot.util.MyMapper;

import java.util.List;

public interface StudentMapper extends MyMapper<Student> {

    /**
     * 根据姓名查找
     * @param name 姓名
     * @return 学生列表
     */
    List<Student> findByName(String name);

}