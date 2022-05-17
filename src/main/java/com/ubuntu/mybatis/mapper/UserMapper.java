package com.ubuntu.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ubuntu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.ws.RespectBinding;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapById(@Param("id") Integer id);
}
