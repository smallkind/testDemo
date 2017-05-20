package com.smallkind.demo.service;

import com.smallkind.demo.entity.User;
import com.smallkind.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiang.zhou
 * @create 2017-05-20-09:21
 */
@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    @Transactional(readOnly = false)
    public int insert(User user){
        return userMapper.insert(user);
    }

    public User findByNickname(String nickname){
        return userMapper.findByNickname(nickname);
    }

    @Transactional(readOnly = false)
    public User testTransactional(User user){
        insert(user);
        user.setNickname("testTransactional");
        insert(user);
        int i = 1/0;
        return user;
    }
}
