package com.dao;

import com.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

    void insert(EmployeeEntity employeeEntity);

    void delete(int eid);

    void update(EmployeeEntity employeeEntity);

    List<EmployeeEntity> getAllemp(@Param("pageNum") int pageNum,
                                @Param("pageSize") int pageSize);
}
