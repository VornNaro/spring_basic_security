package com.kshrd.btb_spring_security_class_demo.repository;

import com.kshrd.btb_spring_security_class_demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM users_tb WHERE name = #{name}")
    UserInfo findUserByUsername(String name);
}
