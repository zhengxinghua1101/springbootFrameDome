package com.keeson.controller;

import com.keeson.common.ResultHandler;
import com.keeson.mapper.UserMapper;
import com.keeson.vo.User;
import com.keeson.vo.UserLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserLoginController {

    @Autowired
    private UserMapper userMapper;

    Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @GetMapping("/hh")
    public ResultHandler  hi(){

        logger.info("我被访问了");
        logger.error("我被访问了");
        int data [] = {1,2,3};
        return  ResultHandler.success("我是MSG",data);
    }



    @ApiOperation(value = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userLogin",value = "登录用户信息")
    })
    @PostMapping("/login")
    Map<String,Object> userLogin(@RequestBody UserLogin userLogin ){
        System.out.println("username:"+userLogin.getUsername());
        System.out.println("password:"+userLogin.getPassword());
        Map<String,Object> result = new HashMap<>();
        if("admin".equals(userLogin.getUsername()) ){
            result.put("code",20000);
            Map<String,Object> token = new HashMap<>();
            token.put("token","eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImYyMDI2YzQxLTUyNDktNGJjMS05ZDRjLThjZWQ4NjgyMTQxOCJ9.-WkdKydQNy1CsbmUaZ36LgacEndVoZDWAHPh6vFm5Xp3MT62b6dOnPmM9HK8ggdZTJ5S6miSaSPIiuzxlIMNTQ");
            result.put("data",token);
        }else {
            result.put("error","登录失败");
        }
        return result ;
    }



    @GetMapping("/info")
    Map<String,Object> userInfo(){
        Map<String,Object> result = new HashMap<>();
        result.put("code",20000);
        Map<String,Object> info = new HashMap<>();
        info.put("roles", "admin");
        info.put("introduction", "I am a super administrator");
        info.put("avatar", "https://www.keeson.com/img/logo.svg");
        info.put("name", "Super Admin");
        result.put("data",info);
        return result ;

    }


    @PostMapping("/logout")
    Map<String,Object> userLogout(){
        Map<String,Object> result = new HashMap<>();
        result.put("code",20000);
        result.put("data","success");
        return result ;
    }

    @GetMapping("/getUserList")
    Map<String,Object> getUserList(){
        Map<String,Object> result = new HashMap<>();
        result.put("code",20000);
        List<User> users = userMapper.selectList(null);
        result.put("data",users);
        return result ;
    }





}
