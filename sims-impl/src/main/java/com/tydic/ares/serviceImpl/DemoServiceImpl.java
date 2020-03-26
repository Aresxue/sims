package com.tydic.ares.serviceImpl;

import com.tydic.ares.annotation.TrackTime;
import com.tydic.ares.entity.AcctBalanceEntity;
import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import com.tydic.ares.entity.Teacher;
import com.tydic.ares.jpa.TeacherJPA;
import com.tydic.ares.mapper.DemoMapper;
import com.tydic.ares.mapper.StudentMapper;
import com.tydic.ares.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
//    @RequestMapping(value = "/com/tydic/ares/serviceImpl/findStudentByName")
    @RequestMapping(value = "/demo/findStudentByName")
    @Override
    @TrackTime(param = "昨夜西风凋碧树")
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
//    @RequestMapping(value = "/com/tydic/ares/serviceImpl/findStudentById")
    @RequestMapping(value = "/demo/findStudentById")
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
     * 新增一名教师信息
     *
     * @param teacher
     *
     * @return
     */
    @RequestMapping(value = "/com/tydic/ares/serviceImpl/addStudent")
    @Override
    public ResponseBase addStudentJPA(@RequestBody(required = false) Teacher teacher)
    {
        ResponseBase responseBase = new ResponseBase();

        teacherJPA.save(teacher);

        responseBase.setReturnCode("0000");
        responseBase.setReturnDesc("操作成功");
        return responseBase;
    }

    /**
     * 根据教师id查询教师信息
     *
     * @param teacherId
     *
     * @return
     */
    @Override
    public Teacher findStudentByIdJPA(Long teacherId)
    {
        // 使用findById查询
        Optional<Teacher> optional = teacherJPA.findById(teacherId);
        return optional.orElseGet(Teacher::new);
    }

    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/demo/addStudent")
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

    /**
     * @author: Ares
     * @description: 测试teledb
     * @date: 2019/11/2 11:09
     * @param: [] 请求参数
     * @return: com.tydic.ares.entity.ResponseBase 响应参数
     */
    @RequestMapping(value = "/com/tydic/ares/serviceImpl/testTeledb")
    public ResponseBase testTeledb()
    {
        ResponseBase response = new ResponseBase();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        AcctBalanceEntity acctBalance = demoMapper.testTeledbQueryBalance();
        AcctBalanceEntity balanceEntity = new AcctBalanceEntity();
        balanceEntity.setOldBalance(acctBalance.getBalance());
        balanceEntity.setBalance(acctBalance.getBalance() + 100);
        int i = demoMapper.testTeledbUpdateBalance(balanceEntity);
        if (i == 0)
        {
            logger.error("teledb太菜了");
            throw new RuntimeException("teledb太菜了");
        }

        response.setReturnCode("0000");
        response.setReturnDesc("成功");
        return response;
    }

}
