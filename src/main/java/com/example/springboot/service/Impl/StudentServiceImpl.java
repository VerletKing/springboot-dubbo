package com.example.springboot.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.springboot.dao.StudentMapper;
import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 学生接口的实现类
 *
 * @author hp
 * @data 2017/11/2
 */
@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
