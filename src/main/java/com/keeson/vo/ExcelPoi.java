package com.keeson.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class ExcelPoi {

    private Long id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "头像", type = 1) //	type导出类型 1 是文本 2 是图片,3 是函数,10 是数字 默认是文本
    private String image;


    @Excel(name = "爱好")
    private String hobby;

    @Excel(name = "时分秒")
    private LocalTime createTime;


    @Excel(name = "年月日")
    private LocalDate createDate;


    @Excel(name = "日期时间", exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDatetime;


}
