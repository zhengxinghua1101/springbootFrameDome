package com.keeson.controller;

import com.keeson.common.ResultHandler;
import com.keeson.mapper.UserMapper;
import com.keeson.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserMapper userMapper;


    @GetMapping("/getUserData")
    ResultHandler getAllUser(){
        List<User> users = userMapper.selectList(null);
        System.out.println("aa");
        return  new ResultHandler().success(users);
    }



}
