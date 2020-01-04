package com.dao;

import com.entity.ProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    //分页

    List<ProductEntity> getPageHelper(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    void insert(ProductEntity productEntity);
    void delete(int pid);
    void update(ProductEntity productEntity);


    //查询商品

    List<ProductEntity> searchname(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,@Param("name") String name);

    //修改状态

    void updatestate(Integer pstatus,Integer id);
}
