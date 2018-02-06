package com.tydic.simscloud.serviceImpl;

import com.tydic.simscloud.entity.ResponseBase;
import com.tydic.simscloud.entity.Student;
import com.tydic.simscloud.service.DemoService;
import com.tydic.simscloud.mapper.DemoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试所用
 *
 * @author Ares
 * @date 2018/1/24 11:02
 */
@Service
public class DemoServiceImpl implements DemoService
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoMapper demoMapper;

    /**
     * 根据学生名字查询信息
     *
     * @param student
     *
     * @return
     */
    @Override
    public Student findStudentByName(Student student)
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
    }

    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    @Override
    public ResponseBase addStudent(Student student)
    {
        ResponseBase responseBase = new ResponseBase();
        try
        {
            int infl = demoMapper.addStudent(student);
            if(infl != 0){
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
