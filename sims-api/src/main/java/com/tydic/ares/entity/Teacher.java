package com.tydic.ares.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Ares
 * @Date 2018/7/26 18:36
 * @Description: 教师类
 * @Version JDK 1.8
 */
@Entity
@Table(name = "teacher")
public class Teacher
{
    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_sex")
    private String teacherSex;
    @Column(name = "teacher_age")
    private Long teacherAge;

    public Long getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(Long teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getTeacherSex()
    {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex)
    {
        this.teacherSex = teacherSex;
    }

    public Long getTeacherAge()
    {
        return teacherAge;
    }

    public void setTeacherAge(Long teacherAge)
    {
        this.teacherAge = teacherAge;
    }
}
