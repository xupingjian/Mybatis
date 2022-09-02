package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    //    通过分步查询员工以及员工所对应的部门信息
//    第2步：通过did查询员工所对应的部门信息
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

//    获取部门以及部门中所有的员工信息
    Dept getDeptAndEmp(@Param("did") Integer did);

    Dept getDeptAndEmpByIdone(@Param("did") Integer did);
}
