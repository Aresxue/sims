package com.tydic.ares.service;

import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
