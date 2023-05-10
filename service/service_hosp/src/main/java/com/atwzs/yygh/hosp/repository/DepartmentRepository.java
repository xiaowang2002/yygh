package com.atwzs.yygh.hosp.repository;

import com.atguigu.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName DepartmentRepository
 * @Description
 * @Author WangZhisheng
 * @Date 16:07 2023/5/7
 * @Version 11.0.15
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}
