package com.tydic.simscloud.service;

import com.tydic.simscloud.entity.ResponseBase;
import com.tydic.simscloud.entity.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试所用
 *
 * @author Ares
 * @date 2018/1/24 10:59
 */
@FeignClient(value = "SIMS-IMPL")
public interface DemoService
{
    /**
     * 根据学生名字查询信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/demo/studentQuery")
    Student findStudentByName(Student student);

    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/demo/addStudent")
    ResponseBase addStudent(Student student);

}
