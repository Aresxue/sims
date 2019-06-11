package com.tydic.ares;

import com.tydic.ares.entity.SchoolClass;
import com.tydic.ares.mapper.DemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimsImplApplicationTests
{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    DemoMapper demoMapper;

  /*  @Test
    public void test() throws Exception
    {
        stringRedisTemplate.opsForValue().set("ares", "xue");
        String result = stringRedisTemplate.opsForValue().get("ares");
        System.out.println(result);
    }*/

    @Test
    public void test() throws Exception
    {
        SchoolClass classes = new SchoolClass();
        System.out.println(classes.getStudentList());
        classes.setClassId(2L);
        System.out.println(demoMapper.findStudentByNameTest(classes));
        System.out.println(classes);
    }
}
