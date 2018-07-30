package com.tydic.ares.controller;


import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import com.tydic.ares.remote.DemoRemote;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试所用
 *
 * @author Ares
 * @date 2018/1/24 10:57
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoRemote demoRemote;

    @RequestMapping(value = "/findStudentByName")
    public Student findStudentByName(HttpServletRequest request, @RequestBody(required = false) String parameters)
    {
        try
        {
            JSONObject jsonObject = JSONObject.fromObject(parameters);
            String studentName = jsonObject.getString("studentName");
            logger.info("studentName:" + studentName);
            Student student = new Student();
            student.setStudentName(studentName);
            student = demoRemote.findStudentByName(student);
            return student;
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            logger.error("我有种不好的预感", e);
            throw new RuntimeException("阿哦,出错了");
        }
    }

    @RequestMapping(value = "/addStudent")
    public ResponseBase addStudent(HttpServletRequest request, @RequestBody(required = false) String parameters)
    {
        try
        {
            JSONObject jsonObject = JSONObject.fromObject(parameters);
            String studentName = jsonObject.getString("studentName");
            String studentId = jsonObject.getString("studentId");
            String classId = jsonObject.getString("classId");
            String studentSex = jsonObject.getString("studentSex");
            String studentAge = jsonObject.getString("studentAge");
            Student student = new Student();
            student.setStudentName(studentName);
            student.setStudentId(Long.valueOf(studentId));
            student.setClassId(Long.valueOf(classId));
            student.setStudentSex(studentSex);
            student.setStudentAge(Long.valueOf(studentAge));
            ResponseBase responseBase = demoRemote.addStudent(student);
            return responseBase;
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            logger.error("我有种不好的预感", e);
            throw new RuntimeException("阿哦,出错了");
        }
    }

}
