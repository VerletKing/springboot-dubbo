package com.example.springboot.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * StatViewServlet
 *
 * @author hp
 * @data 2017/11/1
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "loginUsername", value = "root"),
        @WebInitParam(name = "loginPassword", value = "root"),
        @WebInitParam(name = "resetEnable", value = "false")
})
public class DruidStatViewServlet extends StatViewServlet {
}
