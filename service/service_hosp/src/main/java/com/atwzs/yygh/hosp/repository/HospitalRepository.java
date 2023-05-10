package com.atwzs.yygh.hosp.repository;

import com.atguigu.yygh.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @ClassName HosptialRepository
 * @Description
 * @Author WangZhisheng
 * @Date 13:01 2023/5/6
 * @Version 11.0.15
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {

    /**
     * 判断是否存在数据
     **/
    Hospital getHospitalByHoscode(String hoscode);
}
