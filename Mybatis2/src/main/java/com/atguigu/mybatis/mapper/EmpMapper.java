package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
// 查询所有员工数据
    List<Emp> getAllEmp();

//    查询员工以及员工所对应的部门信息
    Emp getEmpAndDept(@Param("eid") Integer eid);

//    通过分步查询员工以及员工所对应的部门信息
//    第1步：查询员工信息
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    List<Emp> getDeptAndEmpByIdtwo(@Param("did") Integer did);
}
