package com.tydic.ares.config;

import com.tydic.ares.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: Ares
 * @Date: 2019/7/25 15:41
 * @Description:
 * @Version: JDK 1.8
 */
@Component
@ConfigurationProperties(prefix = "love")
public class ConfigurationPropertiesDemo
{
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationPropertiesDemo.class);

    private String myName;
    private String result;

    private Student student;

    private Map map;
    private List list;

    @PostConstruct
    public void initMethod()
    {
        logger.info(myName);
        logger.info(result);
        logger.info(Optional.ofNullable(student).toString());
        logger.info(Optional.ofNullable(list).toString());
        logger.info(Optional.ofNullable(map).toString());
    }

    public String getMyName()
    {
        return myName;
    }

    public void setMyName(String myName)
    {
        this.myName = myName;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public List getList()
    {
        return list;
    }

    public void setList(List list)
    {
        this.list = list;
    }
}
