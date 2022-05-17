package com.ubuntu.mybatis;

import com.ubuntu.mybatis.pojo.User;
import com.ubuntu.mybatis.service.UserService;
import com.ubuntu.mybatis.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
public class MybatisPlusServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        System.out.println("总记录数:"+userService.count());
    }
    @Test
    public void test2(){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(null, UUID.randomUUID().toString().substring(0,4),20,UUID.randomUUID().toString().substring(0,6)+"@qq.com");
            users.add(user);
        }
        userService.saveBatch(users);
        System.out.println("总记录数:"+userService.count());
    }
    @Test
    public void test3(){
        System.out.println(UUID.randomUUID().toString().substring(0,5));
    }
}
