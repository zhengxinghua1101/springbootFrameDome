package com.keeson.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.keeson.common.ResultHandler;
import com.keeson.mapper.UserMapper;
import com.keeson.vo.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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



    @GetMapping("/download")
    void download() throws IOException {
        List<User> users = userMapper.selectList(null);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户","user"),User.class,users);

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Jeff.zheng.SOFTIDE\\Desktop\\aa.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();




    }



}
