package com.vo;

import lombok.Data;

@Data
public class UserEntityVO {

    //主键

    private Integer uid;

    //用户名

    private String username;

    //密码

    private String password;

    //角色权限 0 --管理员 1--普通用户

//    private String role;
}
