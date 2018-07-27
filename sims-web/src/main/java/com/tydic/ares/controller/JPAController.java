package com.tydic.ares.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tydic.ares.entity.Teacher;
import com.tydic.ares.service.DemoRemote;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author Ares
 * @Date 2018/7/26 19:07
 * @Description:
 * @Version JDK 1.8
 */
@RestController
@RequestMapping(value = "/jpa")
public class JPAController
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoRemote demoRemote;

    @RequestMapping(value = "/findStudentById")
    public Teacher JPAfindStudentById(@RequestBody(required = false) String parameters)
    {
        JSONObject jsonObject = JSONObject.fromObject(parameters);
        Long teacherId = jsonObject.getLong("teacherId");
        logger.info("teacherId:" + teacherId);
        Teacher teacher = demoRemote.JPAfindStudentById(teacherId);
        return teacher;
    }
}
