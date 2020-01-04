package com.dao;

import com.entity.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getAll();

    void insertUser(UserEntity userEntity);

    void deleteUser(int id);

    void updateUer(UserEntity userEntity);
}
