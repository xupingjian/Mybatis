package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
/*mybatis保持两个一致：
* 1.映射文件的namespace要和接口的全类名保持一致
* 2.映射文件的sql语句的id要和mapper接口中的方法名保持一致
*
* 表--实体类--mapper接口--映射文件*/

//    添加用户信息
    int insertUser();
    //修改用户信息
    int updateUser();
    //删除用户信息
    int deleteUser();
//    根据id查询用户信息
    User getUserByid();
//    查询所有用户信息
    List<User> getAllUser();
}
