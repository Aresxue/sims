package com.tydic.ares;

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

    @Test
    public void test() throws Exception
    {
        stringRedisTemplate.opsForValue().set("ares", "xue");
        String result = stringRedisTemplate.opsForValue().get("ares");
        System.out.println(result);
    }
}
