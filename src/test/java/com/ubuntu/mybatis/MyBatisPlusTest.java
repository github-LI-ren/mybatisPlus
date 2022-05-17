package com.ubuntu.mybatis;

import com.ubuntu.mybatis.mapper.UserMapper;
import com.ubuntu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        List<Map<String, Object>> maps = userMapper.selectMaps(null);
        for (Map map:maps){
            for (Object entry: map.entrySet()) {
                Map.Entry entry1 = (Map.Entry<String,Object>) entry;
                System.out.println(entry1);
            }

        }
    }
    @Test
    public void test2(){
        User user = new User();
        user.setName("hangsan2");
        user.setAge(1);
        user.setEmail("zhangsan.com");
        userMapper.insert(user);
    }
    @Test
    public void test3(){
        userMapper.deleteById(780304385);
        userMapper.deleteById(21123073);
        userMapper.deleteById(-75255806);

    }
    @Test
    public void test4(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void test5(){
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(longs);
        for (User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void test6(){
        Map<String, Object> stringObjectMap = userMapper.selectMapById(1);
        System.out.println(stringObjectMap);
    }
}
