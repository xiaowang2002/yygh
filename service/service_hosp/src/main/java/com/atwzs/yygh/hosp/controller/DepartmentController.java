package com.atwzs.yygh.hosp.controller;

import com.atguigu.yygh.vo.hosp.DepartmentVo;
import com.atwzs.yygh.common.result.Result;
import com.atwzs.yygh.hosp.service.DepartmentServie;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description
 * @Author WangZhisheng
 * @Date 21:35 2023/5/10
 * @Version 11.0.15
 */
@RestController
@RequestMapping("/admin/hosp/department")
//@CrossOrigin
public class DepartmentController {

    @Resource
    private DepartmentServie departmentServie;

    /**
     * 根据医院编号，查询医院科室所有列表
     *
     * @param hoscode 医院编号
     * @return R
     */
    @ApiOperation(value = "查询医院所有科室列表")
    @GetMapping("/getDeptList/{hoscode}")
    public Result getDeptList(@PathVariable String hoscode) {
        List<DepartmentVo> list = departmentServie.findDeptTree(hoscode);
        return Result.ok(list);
    }
}
