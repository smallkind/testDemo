package com.smallkind.service;

import com.smallkind.demo.entity.User;
import com.smallkind.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author xiang.zhou
 * @create 2017-05-20-09:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void insert() throws Exception{
        User user = new User();
        user.setNickname("dddd");
        user.setSex("1");
        user.setAge(40);
        user.setPhone("11111111111");
        user.setPassword("88888");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userService.insert(user);
    }

    @Test
    public void testTransactional() throws Exception {
        User user = new User();
        user.setNickname("dddd");
        user.setSex("1");
        user.setAge(40);
        user.setPhone("11111111111");
        user.setPassword("88888");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userService.testTransactional(user);
    }
}
