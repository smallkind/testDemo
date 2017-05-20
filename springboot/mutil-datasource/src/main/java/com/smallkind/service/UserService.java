package com.smallkind.service;

import com.smallkind.primaryDao.PrimaryUserMapper;
import com.smallkind.secondDao.SecondUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
