package com.smallkind.mapper;

import com.smallkind.MybatisApplication;
import com.smallkind.demo.entity.User;
import com.smallkind.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author xiang.zhou
 * @create 2017-05-01-13:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MybatisApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception{
        User user = new User();
        user.setNickname("AAA");
        user.setSex("1");
        user.setAge(20);
        user.setPhone("18123848932");
        user.setPassword("666666");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userMapper.insert(user);
    }

    @Test
    @Transactional
    public void findByName() throws Exception {
        User user = new User();
        user.setNickname("BBB");
        user.setSex("2");
        user.setAge(18);
        user.setPhone("18198765437");
        user.setPassword("888888");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus("1");
        userMapper.insert(user);
        int i = 1/0;
        User u = userMapper.findByNickname("AAA");
        Assert.assertEquals(21, u.getAge());
    }

}
