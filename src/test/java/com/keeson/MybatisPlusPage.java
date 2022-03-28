package com.keeson;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keeson.mapper.UserMapper;
import com.keeson.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPage {

    @Autowired
    private UserMapper userMapper;


    @Test
    void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("age",20);
        Page<User> page = new Page<>(1,10);
        IPage<User>  userIPage = userMapper.selectPage(page,wrapper);
        System.out.println("总条数"+userIPage.getTotal());
        System.out.println("总页数"+userIPage.getPages());
        System.out.println(userIPage);
    }
}
