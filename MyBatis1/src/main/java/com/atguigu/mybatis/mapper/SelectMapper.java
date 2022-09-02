package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
//    根据id查询用户信息
    User getUserById(@Param("id") Integer id);
//    查询用户信息的总记录数
    Integer getCount();
    //    根据id查询用户信息为一个map集合
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

//    查询所有用户信息为map集合
//    List<Map<String,Object>> getAllUserToMap();//多条数据只作为键值不能放在一个Map中，但可以将每一个map放到list中
    @MapKey("id")//把多条数据作为Map中的键（id）对应的值
    Map<String,Object> getAllUserToMap();
}
