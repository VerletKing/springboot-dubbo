package com.example.springboot;

import com.example.springboot.dao.StudentMapper;
import com.example.springboot.dao.TeacherDao;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.Teacher;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherDao teacherDao;

	@Test
	public void contextLoads() {
	    PageHelper.startPage(1,3);
        List<Student> studentList = studentMapper.selectAll();
        PageInfo pageInfo = new PageInfo(studentList);

    }

    @Test
    public void mongodb(){
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("王五");
        teacher.setSalary("100000.00");
	    teacherDao.save(teacher);
    }


}
