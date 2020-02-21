package com.sc.provider.dept.dao;

import com.sc.api.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/17 18:25
 */
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
