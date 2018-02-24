package com.tydic.simscloud.service;

import com.tydic.simscloud.entity.ResponseBase;
import com.tydic.simscloud.entity.Student;
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
    Student findStudentByName(Student student);

    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    ResponseBase addStudent(Student student);

}
