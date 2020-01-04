package com.service.impl;

import com.dao.TypeDao;
import com.entity.TypeEntity;
import com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public List<TypeEntity> getPageHelper(int pageNum, int pageSize) {
        return typeDao.getPageHelper(pageNum,pageSize);
    }

    @Override
    public void insert(TypeEntity typeEntity) {
        typeDao.insert(typeEntity);
    }

    @Override
    public void delete(int id) {
        typeDao.delete(id);
    }

    @Override
    public void update(TypeEntity typeEntity) {
        typeDao.update(typeEntity);
    }
}

//查询商品

//    @Override
//    public List<TypeEntity> searchName(int pageNum, int pageSize, String name) {
//        return typeDao.searchName(pageNum,pageSize);
//    }
//
//    @Override
//    public List<TypeEntity> getAll() {
//        return typeDao.getAll();
//    }
