package com.atwzs.yygh.hosp.service.impl;

import com.atguigu.yygh.model.hosp.HospitalSet;
import com.atwzs.yygh.hosp.mapper.HospitalSetMapper;
import com.atwzs.yygh.hosp.service.HospitalSetService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName HospitalSetServiceImpl
 * @Description
 * @Author WangZhisheng
 * @Date 15:34 2023/4/18
 * @Version 11.0.15
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {
    @Override
    public String getSignKey(String hoscode) {
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        wrapper.eq("hoscode", hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(wrapper);
        return hospitalSet.getSignKey();
    }
    //ServiceImpl内部自动帮我们注入了baseMapper,不需要我们手动注入，直接用就行

}
