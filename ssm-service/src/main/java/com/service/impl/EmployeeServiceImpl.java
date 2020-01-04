package com.service.impl;

import com.dao.EmployeeDao;
import com.entity.EmployeeEntity;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //自动注入dao

    @Autowired
    private EmployeeDao employeeDao;

    //分页查询

    @Override
    public List<EmployeeEntity> getAllemp(int pageNum, int pageSize) {
        return employeeDao.getAllemp(pageNum,pageSize);
    }


    //增加

    @Override
    public void insert(EmployeeEntity employeeEntity) {
        employeeDao.insert(employeeEntity);
    }

    //删除

    @Override
    public void delete(int eid) {
        employeeDao.delete(eid);
    }

    //修改

    @Override
    public void update(EmployeeEntity employeeEntity) {
        employeeDao.update(employeeEntity);
    }
}
