package com.example.springboot.dao;

import com.example.springboot.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 老师dao
 *
 * @author hp
 * @data 2017/11/3
 */
public interface TeacherDao extends MongoRepository<Teacher,Integer>{
}
