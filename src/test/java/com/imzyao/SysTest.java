package com.imzyao;

import com.imzyao.components.RedisCache;
import com.imzyao.security.entity.CustomUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SysTest {

    @Resource
    private RedisCache redisCache;

    @Test
    public void test() {
        CustomUserDetails admin = redisCache.getCacheObject("admin");
        System.out.println(admin);
    }
}
