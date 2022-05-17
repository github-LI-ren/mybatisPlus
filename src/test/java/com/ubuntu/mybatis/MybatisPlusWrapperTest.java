package com.ubuntu.mybatis;

import com.alibaba.druid.sql.visitor.functions.Isnull;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ubuntu.mybatis.mapper.UserMapper;
import com.ubuntu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
public class MybatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","b")
                        .between("age",10,20)
                        .isNotNull("email");

        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void test1(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("email")
                        .orderByAsc("uid");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void test2(){

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name",4088)
                .or().gt("age",10);
        User user = new User(null,"6000",30, UUID.randomUUID().toString().substring(0,5)+"@qq.com");
        userMapper.update(user,userQueryWrapper);
    }
    @Test
    //SELECT uid,name FROM user WHERE (uid > ?)
    public void test3(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("uid","name")
                        .gt("uid",5);
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        for (Map map:maps){
            System.out.println(map);
        }
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        User user = new User(null, "lining", 38, null);
        updateWrapper.eq("uid",1);
        userMapper.update(user,updateWrapper);
    }

    /**
     *
     */
    @Test
    public void test4(){
        double a = 0.6E-3;
        long l = 0xfff;
        Object[][] aa=new  Object[3][];
        aa[1] = new Object[3];

    }

    @Test
    public void test5(){
        User user = userMapper.selectById(1);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("uid","name")
                        .gt("uid",6)
                .like(user.getEmail()!=null,"email","qq");
        for (User user1 : userMapper.selectList(userQueryWrapper)) {
            System.out.println(user1);
        }

    }
}
