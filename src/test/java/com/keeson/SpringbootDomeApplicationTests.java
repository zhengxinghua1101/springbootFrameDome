package com.keeson;

import com.keeson.mapper.UserMapper;
import com.keeson.utils.JWTUtils;
import com.keeson.utils.RedisUtils;
import com.keeson.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootDomeApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private JWTUtils jwtUtils;


    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    @Test
    void test1() {
        User user = new User();
        user.setName("Jack");
        user.setAge(20);
        User u  = userMapper.selectByUserId(user);
        System.out.println(u);

    }


    @Test
    void testRedis() {
        redisUtils.set("name","test");
        String name = redisUtils.get("name");
        System.out.println(name);

    }


    @Test
    void testRedis1() {
        redisUtils.set("name","我的世界",1, TimeUnit.MINUTES);
        String name = redisUtils.get("name");
        System.out.println(name);

    }



    @Test
    void testJWt() {
        String token = jwtUtils.createToken("1212");
        System.out.println(token);
        System.out.println(jwtUtils.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDgwMjA3MjUsInVzZXJJZCI6IjEyMTIifQ.M76g2r7uRO18rUd0x0S4E_vBe28byNeATVNDm0njKlU"));
    }

}
