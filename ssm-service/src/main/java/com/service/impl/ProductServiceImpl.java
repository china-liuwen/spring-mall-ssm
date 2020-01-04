package com.service.impl;

import com.dao.ProductDao;
import com.entity.ProductEntity;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductEntity> getPageHelper(int pageNum, int pageSize) {
        return productDao.getPageHelper(pageNum,pageSize);
    }

    @Override
    public void insert(ProductEntity productEntity) {
        productDao.insert(productEntity);
    }

    @Override
    public void delete(int pid) {
        productDao.delete(pid);
    }

    @Override
    public void update(ProductEntity productEntity) {
        productDao.update(productEntity);
    }
}
