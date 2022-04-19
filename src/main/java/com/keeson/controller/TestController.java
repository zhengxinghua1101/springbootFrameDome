package com.keeson.controller;

import cn.hutool.core.date.DateUtil;
import com.keeson.common.ResultHandler;
import com.keeson.service.UserService;
import com.keeson.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
public class TestController {


    @Autowired
    UserService userService;

    @Autowired
    UserServiceImpl userServiceimpl;


    @ApiOperation("home")
    @GetMapping("/")
    ResultHandler home(){
        System.out.println("555=="+userService.getById(55));
        System.out.println("666=="+userServiceimpl.getById(66));
        return  ResultHandler.success("1212121", DateUtil.now());
    }





    @PostMapping("/sms")
    ResultHandler shortMessagingService(){
        return  ResultHandler.success();
    }
}
