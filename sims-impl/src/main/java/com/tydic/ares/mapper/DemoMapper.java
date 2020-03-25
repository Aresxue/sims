package com.tydic.ares.mapper;


import com.tydic.ares.annotation.TrackTime;
import com.tydic.ares.entity.AcctBalanceEntity;
import com.tydic.ares.entity.SchoolClass;
import com.tydic.ares.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 测试mybatis
 */
@Repository
@Mapper
public interface DemoMapper
{
    /**
     * 根据学生名查询学生信息
     *
     * @param student
     *
     * @return
     */
    @TrackTime
    Student findStudentByName(Student student);

    /**
     * 新增一名学生信息
     *
     * @param student
     *
     * @return
     */
    int addStudent(Student student);

    /**
     * @author: Ares
     * @description: 批量新增学生信息
     * @date: 2019/8/30 14:32
     * @param: [students] 请求参数
     * @return: int 响应参数
     */
    int addStudentBatch(List<Student> students);

    List<Student> findStudentByNameTest(SchoolClass schoolClass);

    /**
     * @author: Ares
     * @description: 测试teledb的事务问题
     * @date: 2019/11/2 10:51
     * @param: [] 请求参数
     * @return:  响应参数
     */
    int testTeledbUpdateBalance(AcctBalanceEntity acctBalance);
    /**
     * @author: Ares
     * @description: 测试teledb的事务问题
     * @date: 2019/11/2 10:51
     * @param: [] 请求参数
     * @return:  响应参数
     */
    AcctBalanceEntity testTeledbQueryBalance();
}
