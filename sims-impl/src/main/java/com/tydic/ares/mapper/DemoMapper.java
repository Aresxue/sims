package com.tydic.ares.mapper;


import com.tydic.ares.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试mybatis
 */
@Mapper
public interface DemoMapper
{
    /**
     * 根据学生名查询学生信息
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
    int addStudent(Student student);
}
