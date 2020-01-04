package com.service;

import com.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();

    void deleteUser(int id);

    void insertUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);
}
