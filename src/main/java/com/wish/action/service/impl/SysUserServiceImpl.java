package com.wish.action.service.impl;

import com.wish.action.dao.sys.entity.User;
import com.wish.action.dao.sys.mapper.UserMapper;
import com.wish.action.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/6/26 17:34
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User getUserById(Long id) {

        User user=userMapper.selectByPrimaryKey(id);

        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return new User(1L,"fqh","123456","test");
    }
}
