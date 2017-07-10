package com.soda.app.service.impl;

import com.soda.app.mapper.UserMapper;
import com.soda.app.model.User;
import com.soda.app.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Cacheable("user")
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @CacheEvict("user")
    public List<User> evictUser() {
        return userMapper.listUser();
    }

}
