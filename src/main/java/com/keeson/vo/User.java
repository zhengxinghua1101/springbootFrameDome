package com.keeson.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
@ExcelTarget("xh_user")
public class User {

    private Long id;

    //@TableField(value = "col_name") 数据库字段名col_name 对应实体类name
    @TableField(value = "col_name")
    @Excel(name = "姓名")
    private String name;

    @TableField(value = "col_age")
    @Excel(name = "年龄", suffix = "岁")
    private Integer age;

    @TableField(value = "col_email")
    @Excel(name = "邮箱", type = 1)
    private String email;
}
