package com.tydic.ares.remote;

import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ares
 * @date 2018/3/2 16:48
 */
@FeignClient(value = "SIMS-IMPL", fallback = DemoRemoteHystric.class)
public interface DemoRemote
{
    /**
     * 根据学生名字查询信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/com/tydic/ares/serviceImpl/findStudentByName")
    Student findStudentByName(Student student);


    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    @RequestMapping(value = "/com/tydic/ares/serviceImpl//addStudent")
    ResponseBase addStudent(Student student);

    /**
     * 根据学生id查询学生信息
     * feign传单独的参数时要使用@RequestParam,值与调用的生产者形参一致
     * 实体则不需要加注解，若多个，则需要加上@RequestBody
     * @param studentId
     *
     * @return
     */
    @RequestMapping(value = "/com/tydic/ares/serviceImpl//findStudentById")
    Student findStudentById(@RequestParam("studentId")Long studentId);
}
