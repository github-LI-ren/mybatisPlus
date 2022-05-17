package com.ubuntu.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.prism.Texture;
import lombok.*;

@Data
@AllArgsConstructor
public class User {

    @TableId(value = "uid",type =  IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    public User() {
    }
}
