package com.tydic.ares.mapper;

import com.tydic.ares.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Ares
 * @date 2018/7/26 15:33
 * @description: mybatis另一种使用方式
 * @version JDK 1.8
 */
@Mapper
@Repository
public interface StudentMapper
{
    /**
     * 根据学生名查询学生信息
     *
     * @param student
     *
     * @return
     */
    @Select("SELECT student_id, class_id, student_name, student_sex, student_age FROM student WHERE student_name = #{studentName}")
    Student findStudentByName(Student student);

    /**
     * 根据id查询学生信息
     *
     * @param studentId
     *
     * @return
     */
    //    @Select("SELECT student_id, class_id, student_name, student_sex, student_age FROM student WHERE student_id = #{studentId}")
    //    Student findStudentById(@param("studentId") Long studentId);
    //和上面等价，单参数使用时#{参数名}即可取出值，参数名随意取
    @Select("SELECT student_id, class_id, student_name, student_sex, student_age FROM student WHERE student_id = #{studentId}")
    Student findStudentById(Long studentId);
}
