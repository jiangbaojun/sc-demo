package com.sc.provider.dept.service;

import com.sc.api.entity.Dept;
import com.sc.provider.dept.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/17 18:38
 */
@Service
public class DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept){
        return deptDao.addDept(dept);
    }

    public Dept queryById(Long id){
        return deptDao.queryById(id);
    }

    public List<Dept> queryAll(){
        return deptDao.queryAll();
    }
}
