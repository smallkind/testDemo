package com.smallkind.demo.mapper;

import com.smallkind.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author xiang.zhou
 * @create 2017-05-01-13:21
 */
@Repository
@Mapper
public interface UserMapper {

    @Select("select * from user where nickname = #{nickname}")
    User findByNickname(@Param("nickname")String nickname);

    @Insert("insert into user(nickname,sex,age,phone,password,create_time,update_time,status) values(#{nickname},#{sex},#{age},#{phone},#{password},#{createTime},#{updateTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
}
