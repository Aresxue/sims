package com.tydic.ares.remote;

import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试所用
 * @RequestMapping必须要有，且value值不能为空至少为/，/之后的path为任何值都不影响调用，但不同接口的path不能相同
 * @author Ares
 * @date 2018/1/24 10:59
 */
public interface DemoService
{
    /**
     * 根据学生名字查询信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/findStudentByNameAres")
    Student findStudentByName(Student student);


    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/addStudentAres")
    ResponseBase addStudent(Student student);

}
