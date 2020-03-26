package com.tydic.ares.remote;

import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Author Ares
 * @Date 2018/7/31 18:32
 * @Description:
 * @Version JDK 1.8
 */

@Component
public class DemoRemoteHystric implements DemoRemote
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Student findStudentByName(Student student)
    {
        logger.error("我在找一个学生时出错了");
        student = new Student();
        student.setStudentName("我是一个假学生");
        student.setStudentAge(10000);
        return student;
    }

    @Override
    public ResponseBase addStudent(Student student)
    {
        return null;
    }

    @Override
    public Student findStudentById(Long studentId)
    {
        return null;
    }
}
