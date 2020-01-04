package com.service;

import com.entity.TypeEntity;

import java.util.List;

public interface TypeService {

    //分页

    List<TypeEntity> getPageHelper(int pageNum, int pageSize);

    //查询商品

//    List<TypeEntity> searchName(int pageNum,int pageSize,String name);
//
//    List<TypeEntity> getAll();

    void insert(TypeEntity typeEntity);
    void delete(int id);
    void update(TypeEntity typeEntity);


}