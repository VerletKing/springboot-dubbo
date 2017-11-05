package com.example.springboot;

import com.example.springboot.dao.StudentMapper;
import com.example.springboot.dao.TeacherDao;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.Teacher;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
        studentMapper.findByName("张");
    }

    @Test
    public void mongodb() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("王五");
        teacher.setSalary("100000.00");
        teacherDao.save(teacher);
    }

    @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("name","tom");
    }

    @Test
    public void readRedis(){
        System.out.println(redisTemplate.opsForValue().get("name"));
    }


}
