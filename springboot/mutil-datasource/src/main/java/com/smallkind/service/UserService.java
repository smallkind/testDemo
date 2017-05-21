package com.smallkind.service;

import com.smallkind.entity.User;
import com.smallkind.primaryDao.PrimaryUserMapper;
import com.smallkind.secondDao.SecondUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiang.zhou
 * @create 2017-05-20-19:56
 */
@Service
public class UserService {

    @Autowired
    private PrimaryUserMapper primaryUserMapper;

    @Autowired
    private SecondUserMapper secondUserMapper;

    public int primaryInsert(User user){
        return primaryUserMapper.insert(user);
    }

    public int secondInsert(User user){
        return secondUserMapper.insert(user);
    }

    @Transactional(value = "primaryTransactionManager")
    public void transactionPrimaryInsert(User user){
        primaryUserMapper.insert(user);
        int i = 1/0;
    }

    @Transactional(value = "secondTransactionManager")
    public void transactionSecondInsert(User user){
        secondUserMapper.insert(user);
        int i = 1/0;
    }
}
