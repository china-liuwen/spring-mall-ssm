package com.entity;


import lombok.Data;

/**
 *      用户表
 */
@Data
public class UserEntity {

    private Integer uid;

    private String username;

    private String password;
}
