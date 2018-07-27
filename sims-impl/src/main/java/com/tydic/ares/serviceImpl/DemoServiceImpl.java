package com.tydic.ares.serviceImpl;

import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import com.tydic.ares.entity.Teacher;
import com.tydic.ares.jpa.TeacherJPA;
import com.tydic.ares.mapper.DemoMapper;
import com.tydic.ares.mapper.StudentMapper;
import com.tydic.ares.service.DemoService;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试所用
 *
 * @author Ares
 * @date 2018/1/24 11:02
 */
@RestController
@Service
public class DemoServiceImpl implements DemoService
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherJPA teacherJPA;

    /**
     * 根据学生名字查询信息
     *
     * @param student
     *
     * @return
     */
    @Override
   /* public Student findStudentByName(@RequestBody(required = false) Student student)
    {
        Student studentInfo = null;
        try
        {
            studentInfo = demoMapper.findStudentByName(student);
        } catch (Exception e)
        {
            logger.error("查询学生信息原子服务出错", e);
        }
        return studentInfo;
    }*/ public Student findStudentByName(@RequestBody(required = false) Student student)
    {
        Student studentInfo = null;
        try
        {
            studentInfo = studentMapper.findStudentByName(student);
        } catch (Exception e)
        {
            logger.error("查询学生信息原子服务出错", e);
        }
        return studentInfo;
    }

    /**
     * 根据学生id查询学生信息
     *
     * @param studentId
     *
     * @return
     */
    @Override
    public Student findStudentById(Long studentId)
    {
        Student studentInfo = null;
        try
        {
            studentInfo = studentMapper.findStudentById(studentId);
        } catch (Exception e)
        {
            logger.error("查询学生信息原子服务出错", e);
        }
        return studentInfo;
    }


    /**
     * JPA版
     * 根据学生id查询学生信息
     *
     * @param studentId
     *
     * @return
     */
    @Override
    public Teacher JPAfindStudentById(Long studentId)
    {
        //使用findById查询
        return teacherJPA.findOne(studentId);
    }

    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    @Override
    public ResponseBase addStudent(@RequestBody(required = false) Student student)
    {
        ResponseBase responseBase = new ResponseBase();
        try
        {
            int infl = demoMapper.addStudent(student);
            if (infl != 0)
            {
                responseBase.setReturnCode("0000");
                responseBase.setReturnDesc("操作成功");
            }
        } catch (Exception e)
        {
            logger.error("新增一名学生信息原子服务调用失败", e);
            responseBase.setReturnCode("0001");
            responseBase.setReturnDesc("新增一名学生信息原子服务调用失败");
        }
        return responseBase;
    }

}
