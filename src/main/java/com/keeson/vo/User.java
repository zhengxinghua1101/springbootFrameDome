package com.keeson.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    private Long id;

    //@TableField(value = "col_name") 数据库字段名col_name 对应实体类name
    @TableField(value = "col_name")
    private String name;

    @TableField(value = "col_age")
    private Integer age;

    @TableField(value = "col_email")
    private String email;
}
