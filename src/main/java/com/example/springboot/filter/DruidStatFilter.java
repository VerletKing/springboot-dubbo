package com.example.springboot.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * WebStatFilter
 *
 * @author hp
 * @data 2017/11/1
 */
@WebFilter(filterName = "druidWebStatFilter",urlPatterns = "/*",initParams = {
        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
})
public class DruidStatFilter extends WebStatFilter {
}
