package com.dao;

import com.entity.TypeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeDao {

    void insert(TypeEntity typeEntity);

    void delete(int id);

    void update(TypeEntity typeEntity);


    List<TypeEntity> getPageHelper(@Param("pageNum") int pageNum,
                            @Param("pageSize") int pageSize);

    //查询商品
//
//    List<TypeEntity> searchName(@Param("pageNum") int pageNum,
//                                @Param("pageSize") int pageSize);

}