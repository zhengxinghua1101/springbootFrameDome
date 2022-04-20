package com.keeson.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keeson.mapper.UserMapper;
import com.keeson.service.UserService;
import com.keeson.vo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
