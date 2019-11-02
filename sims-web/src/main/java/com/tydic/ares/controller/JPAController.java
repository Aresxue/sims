package com.tydic.ares.controller;

import com.tydic.ares.entity.Teacher;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(JPAController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findStudentById")
    public Teacher JPAfindStudentById(@RequestBody(required = false) String parameters)
    {
        JSONObject jsonObject = JSONObject.fromObject(parameters);
        Long teacherId = jsonObject.getLong("teacherId");
        LOGGER.info("teacherId:" + teacherId);
        Teacher teacher = restTemplate.postForObject("http://SIMS-IMPL/com/tydic/ares/serviceImpl/findStudentByIdJPA", teacherId, Teacher.class);
        return teacher;
    }
}
