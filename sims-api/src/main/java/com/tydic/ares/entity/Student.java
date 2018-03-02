package com.tydic.ares.entity;

/**
 * 学生实体类
 *
 * @author Ares
 * @date 2018/1/24 10:36
 */
public class Student
{
    private Long studentId;
    private Long classId;
    private String studentName;
    private String studentSex;
    private Long studentAge;

    public Long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getClassId()
    {
        return classId;
    }

    public void setClassId(Long classId)
    {
        this.classId = classId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentSex()
    {
        return studentSex;
    }

    public void setStudentSex(String studentSex)
    {
        this.studentSex = studentSex;
    }

    public Long getStudentAge()
    {
        return studentAge;
    }

    public void setStudentAge(Long studentAge)
    {
        this.studentAge = studentAge;
    }
}
