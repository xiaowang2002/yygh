package com.atwzs.yygh.hosp.service;

import com.atguigu.yygh.model.hosp.Department;
import com.atguigu.yygh.vo.hosp.DepartmentQueryVo;
import com.atguigu.yygh.vo.hosp.DepartmentVo;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DepartmentServie
 * @Description
 * @Author WangZhisheng
 * @Date 16:08 2023/5/7
 * @Version 11.0.15
 */
public interface DepartmentServie {
    void save(Map<String, Object> paramMap);

    Page<Department> selectPage(int page, int limit, DepartmentQueryVo departmentQueryVo);

    void remove(String hoscode, String depcode);

    List<DepartmentVo> findDeptTree(String hoscode);

    String getDepName(String hoscode, String depcode);

    Department getDepartment(String hoscode, String depcode);
}
