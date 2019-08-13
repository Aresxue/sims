package com.tydic.ares.service;

import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试所用
 *
 * @author Ares
 * @date 2018/1/24 10:59
 */
public interface DemoService
{
    /**
     * 根据学生名字查询信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/findStudentByNameAres")
    Student findStudentByName(Student student);


    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/addStudentAres")
    ResponseBase addStudent(Student student);

    /**
     * 根据学生id查询学生信息
     * feign传单独的参数时要使用@RequestParam,值与调用的生产者形参一致
     * 实体则不需要加注解，若多个，则需要加上@RequestBody
     * @param studentId
     *
     * @return
     */
    @RequestMapping(value = "/findStudentByIdAres")
    Student findStudentById(@RequestParam("studentId")Long studentId);

    @RequestMapping(value = "/JPAfindStudentById")
    Teacher JPAfindStudentById(@RequestParam("studentId")Long studentId);
}
