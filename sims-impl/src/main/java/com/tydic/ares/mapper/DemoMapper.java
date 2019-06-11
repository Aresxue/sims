package com.tydic.ares.mapper;


import com.tydic.ares.annotation.TrackTime;
import com.tydic.ares.entity.SchoolClass;
import com.tydic.ares.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 测试mybatis
 */
@Repository
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
    @TrackTime
    Student findStudentByName(Student student);

    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    int addStudent(Student student);

    List<Student> findStudentByNameTest(SchoolClass schoolClass);
}
