package com.atwzs.yygh.hosp.service;

import com.atguigu.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ClassName HospitalSetService
 * @Description
 * @Author WangZhisheng
 * @Date 15:33 2023/4/18
 * @Version 11.0.15
 */
public interface HospitalSetService extends IService<HospitalSet> {
    String getSignKey(String hoscode);
}
