package com.smallkind.secondDao;

import com.smallkind.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author xiang.zhou
 * @create 2017-05-20-19:56
 */
@Mapper
public interface SecondUserMapper {

    @Insert("insert into user(nickname,sex,age,phone,password,create_time,update_time,status) values(#{nickname},#{sex},#{age},#{phone},#{password},#{createTime},#{updateTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
}
