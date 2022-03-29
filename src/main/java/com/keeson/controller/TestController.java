package com.keeson.controller;

import com.keeson.common.ResultHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
public class TestController {


    @ApiOperation("home")
    @GetMapping("/")
    ResultHandler home(){
        return  ResultHandler.success("1212121","6666");
    }



    @PostMapping("/sms")
    ResultHandler shortMessagingService(){
        return  ResultHandler.success();
    }
}
