package com.keeson.controller;

import cn.hutool.core.date.DateUtil;
import com.keeson.common.ResultHandler;
import com.keeson.service.UserService;
import com.keeson.service.impl.UserServiceImpl;
import com.keeson.vo.ExcelPoi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "测试接口")
public class TestController {


    @Autowired
    UserService userService;

    @Autowired
    UserServiceImpl userServiceimpl;


    @ApiOperation("home")
    @GetMapping("/")
    ResultHandler home() {
        System.out.println("555==" + userService.getById(55));
        System.out.println("666==" + userServiceimpl.getById(66));
        return ResultHandler.success("1212121", DateUtil.now());
    }


    @PostMapping("/api/v2/detection/productionSave")
    ResultHandler productionSave(@RequestParam Map<String ,Object> map)
    {
        System.out.println("开始"+map.toString());
        return ResultHandler.success(map.toString());
    }

//    @PostMapping("/api/v2/detection/productionSave")
//    ResultHandler productionSave1(@RequestBody Map<String ,Object> map)
//    {
//        System.out.println("开始1"+map.toString());
//        return ResultHandler.success(map.toString());
//    }


    @GetMapping("/my_test")
    ResultHandler my_test(ExcelPoi excelPoi)
    {
        System.out.println(excelPoi);
        System.out.println("开始");
        return ResultHandler.success();
    }




    @PostMapping("/sms")
    ResultHandler shortMessagingService() {
        return ResultHandler.success();
    }
}
