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
    private Integer classId;
    private String studentName;
    private String studentSex;
    private Integer studentAge;

    private long testValue;

    public Long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Integer getClassId()
    {
        return classId;
    }

    public void setClassId(Integer classId)
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

    public Integer getStudentAge()
    {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge)
    {
        this.studentAge = studentAge;
    }

    public long getTestValue()
    {
        return testValue;
    }

    public void setTestValue(long testValue)
    {
        this.testValue = testValue;
    }

    @Override
    public String toString()
    {
        return "Student{" + "studentId=" + studentId + ", classId=" + classId + ", studentName='" + studentName + '\'' + ", studentSex='" + studentSex + '\'' + ", studentAge=" + studentAge + ", testValue=" + testValue + '}';
    }
}
