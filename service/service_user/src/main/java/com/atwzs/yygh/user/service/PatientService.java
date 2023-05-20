package com.atwzs.yygh.user.service;

import com.atguigu.yygh.model.user.Patient;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @ClassName PatientService
 * @Description
 * @Author WangZhisheng
 * @Date 21:48 2023/5/16
 * @Version 11.0.15
 */
public interface PatientService extends IService<Patient> {
    List<Patient> findAllUserId(Long userId);

    Patient getPatientId(Long id);
}
