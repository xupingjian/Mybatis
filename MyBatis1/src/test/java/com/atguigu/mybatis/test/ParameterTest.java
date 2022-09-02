package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterTest {
    /*
    * MyBatis获取参数的两种方式：${},#{}
    * ${}对应着以前向sql语句传入参数的方法：字符串拼接（可能造成sql注入）
    * #{}对应着以前向sql语句传入参数的方法：占位符赋值*/
    @Test
    public void getAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        System.out.println(allUser);
    }
//    mybatis获取参数的各种情况：
//    1.mapper接口方法的参数为单个的字面量类型：可以通过${}和#{}以任意的字符串（最好是与参数名保持一致）获取参数值，但是需要注意${}的单引号问题
//    2.mapper接口方法的参数为多个时：此时Mybatis会将这些参数放在一个map集合里，以两种方式进行存储：(1).以arg0,arg1为键,以要传的参
//    数为值 (2).以param1,param为键,以要传的参数为值
//    3.若mapper接口方法的参数有多个时:可以手动将这些参数放在一个map中存储,只需要通过#{}和${}以键（自己在map设置的键）的方式访问值，但是需要注意${}的单引号问题
//     4.mapper接口方法的参数是实体类类型的参数:只需要通过#{}和${}以实体类属性的方式访问实体类属性值，但是需要注意${}的单引号问题
//    5.使用@param注解命名参数此时Mybatis会将这些参数放在一个map集合里，以两种方式进行存储：(1).以@Param注解的值为键,以要传的参
//    数为值 (2).以param1,param为键,以要传的参数为值
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user  = mapper.GetUserByUsername("admin");
        System.out.println(user);
    }
    @Test
    public void testcheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user  = mapper.checkLogin("admin","123456");
        System.out.println(user);
    }
    @Test
    public void testcheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user  = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "李四", "41234", 23, "男", "1243"));
        System.out.println(i);
    }
    @Test
    public void testcheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user  = mapper.checkLoginByParam("admin","123456");
        System.out.println(user);
    }
}
