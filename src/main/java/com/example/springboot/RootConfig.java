package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 主配置
 *
 * @author hp
 * @data 2017/11/1
 */
@Configuration
@MapperScan("com.example.springboot.dao")
public class RootConfig {

}
