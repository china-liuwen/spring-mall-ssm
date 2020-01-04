package com.service;

import com.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getPageHelper(int pageNum,int pageSize);
    void insert(ProductEntity productEntity);
    void delete(int pid);
    void update(ProductEntity productEntity);

    //List<ProductEntity> searchName(int pageNum,int pageSize,String name);
    //
    //	boolean updateState(Integer pStatus,Integer id);
}
