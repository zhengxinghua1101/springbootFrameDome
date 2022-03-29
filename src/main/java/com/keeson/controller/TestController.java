package com.keeson.controller;

import com.keeson.common.ResultHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/")
    ResultHandler home(){
        return  ResultHandler.success();
    }



    @PostMapping("/sms")
    ResultHandler shortMessagingService(){
        return  ResultHandler.success();
    }
}
