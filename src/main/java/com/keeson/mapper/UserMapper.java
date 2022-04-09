package com.keeson.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keeson.vo.User;
import org.springframework.stereotype.Repository;

@DS("master")
@Repository //声明持久层操作的bean
public interface UserMapper  extends BaseMapper<User> {


    User selectByUserId(User user);


}
