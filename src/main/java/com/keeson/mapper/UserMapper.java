package com.keeson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keeson.vo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper  extends BaseMapper<User> {


    User selectByUserId(User user);


}
