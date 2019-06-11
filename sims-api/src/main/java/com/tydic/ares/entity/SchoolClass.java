package com.tydic.ares.entity;

import java.util.List;

/**
 * @Author: Ares
 * @Date: 2019/6/5 15:19
 * @Description: 班级
 * @Version: JDK 1.8
 */
public class SchoolClass
{
    private Long classId;
    private List<Student> studentList;

    public Long getClassId()
    {
        return classId;
    }

    public void setClassId(Long classId)
    {
        this.classId = classId;
    }

    public List<Student> getStudentList()
    {
        return studentList;
    }

    public void setStudentList(List<Student> studentList)
    {
        this.studentList = studentList;
    }

    @Override
    public String toString()
    {
        return "SchoolClass{" + "classId='" + classId + '\'' + ", studentList=" + studentList + '}';
    }
}
