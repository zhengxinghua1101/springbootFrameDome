package com.keeson;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keeson.mapper.ExcelPoiMapper;
import com.keeson.mapper.UserMapper;
import com.keeson.vo.ExcelPoi;
import com.keeson.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

/**
 * 查询
 */
@SpringBootTest
public class MybatisPlusWrapper {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ExcelPoiMapper excelPoiMapper;


    @Test
    void test1(){
        //SELECT id,col_name AS name,col_age AS age,col_email AS email FROM xh_user WHERE (id >= ?)
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("id",100L);
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);

    }

    @Test
    void test2(){
        List<User> users = userMapper.selectList(new QueryWrapper<User>().ge("id",300L));
        System.out.println(users);
    }


    @Test
    void test3(){
        //SELECT id,col_name AS name,col_age AS age,col_email AS email FROM xh_user WHERE (id <= ?)
        List<User> users = userMapper.selectList(new QueryWrapper<User>().le("id",10L));
        System.out.println(users);
    }

    @Test
    void test4(){
        // SELECT id,col_name AS name,col_age AS age,col_email AS email FROM xh_user WHERE (id BETWEEN ? AND ?)
        List<User> users = userMapper.selectList(new QueryWrapper<User>().between("id",10L,20L));
        System.out.println(users);
    }



    @Test
    void test5(){
        // in("id",{1,2,3})--->id in (1,2,3)
        //SELECT id,col_name AS name,col_age AS age,col_email AS email FROM xh_user WHERE (id IN (?,?,?))
        List<User> users = userMapper.selectList(new QueryWrapper<User>().in("id",1,2,3));
        System.out.println(users);
    }


    @Test
    void test6(){
        //SELECT id,col_name AS name,col_age AS age,col_email AS email FROM xh_user WHERE (id IN (select id from xh_user where col_age < 20))
        List<User> users = userMapper.selectList(new QueryWrapper<User>().inSql("id","select id from xh_user where col_age < 20"));
        System.out.println(users);
    }

    /**
     * 排序
     */
    @Test
    void test7(){
        //SELECT id,col_name AS name,col_age AS age,col_email AS email FROM xh_user WHERE (id <= ?) GROUP BY id,name
        List<User> users = userMapper.selectList(new QueryWrapper<User>().groupBy("id","name").le("id",20L));
        System.out.println(users);
    }


    @Test
    void test8(){
        //SELECT id,col_class,col_name,col_image,col_hobby,create_time,create_date,create_datetime FROM xh_excel_poi
        List<ExcelPoi> excelPois = excelPoiMapper.selectList(null);
        System.out.println(excelPois);
    }













}
