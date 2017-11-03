package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 老师
 *
 * @author hp
 * @data 2017/11/3
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Teacher {

    @Id
    private Integer id;

    private String name;

    private String salary;
}
