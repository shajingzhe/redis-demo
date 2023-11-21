package com.xspace.redisdemo;

import cn.hutool.json.JSONUtil;
import com.xspace.redisdemo.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    private String key="user:model:49";
    @Test
    void testString() {
        User user=new User("哈哈",45);

        // 写入一条String数据
        redisTemplate.opsForValue().set(key, user);
        // 获取string数据
        User user1 = (User) redisTemplate.opsForValue().get(key);
        System.out.println(user1);
    }

}
