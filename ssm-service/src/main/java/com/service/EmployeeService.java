package com.service;

import com.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> getAllemp(int pageNum,int pageSize);

    void insert(EmployeeEntity employeeEntity);

    void delete(int eid);

    void update(EmployeeEntity employeeEntity);
}
