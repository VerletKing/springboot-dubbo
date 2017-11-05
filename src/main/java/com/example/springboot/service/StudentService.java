package com.example.springboot.service;

import com.example.springboot.entity.Student;

import java.util.List;

/**
 * 学生服务接口
 *
 * @author hp
 * @data 2017/11/2
 */
public interface StudentService {

    /**
     * 获取全部学生
     *
     * @return 学生列表
     */
    List<Student> findAll();

    /**
     * 根据id查找学生
     *
     * @param id 学生id
     * @return Student
     */
    Student findById(Integer id);

    /**
     * 根据姓名查找
     * @param name 姓名
     * @return 学生列表
     */
    List<Student> findByName(String name);

}
