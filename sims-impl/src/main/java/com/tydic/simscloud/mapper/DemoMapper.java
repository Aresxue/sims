package com.tydic.simscloud.mapper;


import com.tydic.simscloud.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试mybatis
 *
 * @author Ares
 * @date 2018/1/24 10:46
 */
@Mapper
public interface DemoMapper
{
    /**
     * 根据学生名查询学生信息
     * @param student
     * @return
     */
    Student findStudentByName(Student student);

    /**
     * 新增一名学生信息
     * @param student
     * @return
     */
    int addStudent(Student student);
}
