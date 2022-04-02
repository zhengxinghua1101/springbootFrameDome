package com.keeson;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.keeson.mapper.UserMapper;
import com.keeson.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusUpdateWrapper {


    @Autowired
    UserMapper userMapper;


    @Test
    void test1(){
        //UPDATE xh_user SET col_age=? WHERE (id = ?)
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("col_age",20);
        userUpdateWrapper.eq("id",1L);
        int update = userMapper.update(new User(), userUpdateWrapper);
        System.out.println(update);
    }



    @Test
    void test2(){
        //UPDATE xh_user SET col_age=? WHERE (id = ?)
        int update = userMapper.update(new User(), new UpdateWrapper<User>().set("col_age",25).eq("id",1L));
        System.out.println(update);
    }



    @Test
    void test3(){

    }


    @Test
    void test4(){

    }


    @Test
    void test5(){

    }




}
