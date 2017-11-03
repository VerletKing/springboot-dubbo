package com.example.springboot;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * mongo配置
 *
 * @author hp
 * @data 2017/11/3
 */
@Configuration
@EnableMongoRepositories("com.example.springboot.dao")
public class MongoConfig extends AbstractMongoConfiguration{


    @Override
    protected String getDatabaseName() {
        return "springboot";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("192.168.0.128",27017);
    }
}
