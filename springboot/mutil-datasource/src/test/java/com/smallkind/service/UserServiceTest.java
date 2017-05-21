package com.smallkind.service;

import com.smallkind.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author xiang.zhou
 * @create 2017-05-21-14:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void primaryInsertTest(){
        User user = new User();
        user.setNickname("算法卡视角");
        user.setSex("1");
        user.setAge(30);
        user.setPhone("238423032");
        user.setPassword("88888");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userService.primaryInsert(user);
    }

    @Test
    public void secondInsertTest(){
        User user = new User();
        user.setNickname("发送积分");
        user.setSex("1");
        user.setAge(20);
        user.setPhone("2234235230");
        user.setPassword("66666");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userService.secondInsert(user);
    }

    @Test
    public void transactionPrimaryInsertTest(){
        User user = new User();
        user.setNickname("发送积分");
        user.setSex("1");
        user.setAge(20);
        user.setPhone("0000000000");
        user.setPassword("66666");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userService.transactionPrimaryInsert(user);
    }

    @Test
    public void transactionSecondInsertTest(){
        User user = new User();
        user.setNickname("发送积分");
        user.setSex("1");
        user.setAge(20);
        user.setPhone("0000000000");
        user.setPassword("66666");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userService.transactionSecondInsert(user);
    }
}
