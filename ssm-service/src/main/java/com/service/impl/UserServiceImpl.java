package com.service.impl;

import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserEntity> getAll() {
        return userDao.getAll();
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        userDao.insertUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDao.updateUer(userEntity);
    }
}
