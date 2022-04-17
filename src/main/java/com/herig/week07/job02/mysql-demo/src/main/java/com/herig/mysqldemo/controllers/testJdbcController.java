package com.herig.mysqldemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class testJdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @GetMapping("/hello")
    public List<Map<String,Object>> getData(){
        return jdbcTemplate.queryForList("select * from product");
    }
}
