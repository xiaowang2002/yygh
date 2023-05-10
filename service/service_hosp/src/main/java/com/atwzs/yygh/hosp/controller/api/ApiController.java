package com.atwzs.yygh.hosp.controller.api;

import com.atguigu.yygh.model.hosp.Department;
import com.atguigu.yygh.model.hosp.Hospital;
import com.atguigu.yygh.model.hosp.Schedule;
import com.atguigu.yygh.vo.hosp.DepartmentQueryVo;
import com.atguigu.yygh.vo.hosp.ScheduleQueryVo;
import com.atwzs.yygh.common.exception.YyghException;
import com.atwzs.yygh.common.helper.HttpRequestHelper;
import com.atwzs.yygh.common.result.Result;
import com.atwzs.yygh.common.result.ResultCodeEnum;
import com.atwzs.yygh.common.utils.MD5;
import com.atwzs.yygh.hosp.service.DepartmentServie;
import com.atwzs.yygh.hosp.service.HospitalService;
import com.atwzs.yygh.hosp.service.HospitalSetService;
import com.atwzs.yygh.hosp.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName ApiController
 * @Description
 * @Author WangZhisheng
 * @Date 13:04 2023/5/6
 * @Version 11.0.15
 */
@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Resource
    private HospitalService hospitalService;

    @Resource
    private HospitalSetService hospitalSetService;

    @Resource
    private DepartmentServie departmentService;

    @Resource
    private ScheduleService scheduleService;

    @ApiOperation(value = "删除科室")
    @PostMapping("schedule/remove")
    public Result removeSchedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
//必须参数校验 略
        String hoscode = (String) paramMap.get("hoscode");
//必填
        String hosScheduleId = (String) paramMap.get("hosScheduleId");
        if (StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
//签名校验
        //签名校验
        //获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
//        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        scheduleService.remove(hoscode, hosScheduleId);
        return Result.ok();
    }


    /**
     * 查询排班接口
     **/
    @ApiOperation(value = "获取排班分页列表")
    @PostMapping("schedule/list")
    public Result schedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
//必须参数校验 略
        String hoscode = (String) paramMap.get("hoscode");
//非必填
        String depcode = (String) paramMap.get("depcode");
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String) paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 10 : Integer.parseInt((String) paramMap.get("limit"));

        if (StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }

//获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
//        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        ScheduleQueryVo scheduleQueryVo = new ScheduleQueryVo();
        scheduleQueryVo.setHoscode(hoscode);
        scheduleQueryVo.setDepcode(depcode);
        Page<Schedule> pageModel = scheduleService.findPageSchedule(page, limit, scheduleQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * 上传排班接口
     **/
    @ApiOperation(value = "上传排班")
    @PostMapping("saveSchedule")
    public Result<Object> saveSchedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
//必须参数校验 略
        String hoscode = (String) paramMap.get("hoscode");
        if (StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
        //签名校验
        //获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
//        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        scheduleService.save(paramMap);
        return Result.ok();
    }

    @ApiOperation(value = "删除科室")
    @PostMapping("department/remove")
    public Result removeDepartment(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
//必须参数校验 略
        String hoscode = (String) paramMap.get("hoscode");
//必填
        String depcode = (String) paramMap.get("depcode");
        if (StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
//签名校验
        //获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
//        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        departmentService.remove(hoscode, depcode);
        return Result.ok();
    }


    /**
     * 查询可是接口
     **/
    @ApiOperation(value = "获取分页列表")
    @PostMapping("department/list")
    public Result department(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //必须参数校验 略
        String hoscode = (String) paramMap.get("hoscode");
        //非必填
        String depcode = (String) paramMap.get("depcode");
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String) paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 10 : Integer.parseInt((String) paramMap.get("limit"));

        if (StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
        //签名校验
        //获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
//        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        DepartmentQueryVo departmentQueryVo = new DepartmentQueryVo();
        departmentQueryVo.setHoscode(hoscode);
        departmentQueryVo.setDepcode(depcode);
        Page<Department> pageModel = departmentService.selectPage(page, limit, departmentQueryVo);
        return Result.ok(pageModel);
    }


    /**
     * 上传科室接口
     **/
    @PostMapping("/saveDepartment")
    public Result<Object> saveDepartment(HttpServletRequest request) {
        //获取传递过来的科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        //调用service的方法
        departmentService.save(paramMap);
        return Result.ok();
    }

    /**
     * 查询医院
     **/
    @PostMapping("/hospital/show")
    public Result getHospital(HttpServletRequest request) {
        //获取传递过来的医院信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }


        return Result.ok((Hospital) hospitalService.getByHoscode((String) paramMap.get("hoscode")));
    }

    /**
     * 上传医院接口
     **/
    @PostMapping("/saveHospital")
    public Result<Object> saveHosp(HttpServletRequest request) {
        //获取传递过来的医院信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //获取医院系统传递过来的签名
        String hospSign = (String) paramMap.get("sign");

        //根据传递过来的医院编码，查询数据库，数据签名
        String hoscode = (String) paramMap.get("hoscode");

        String signKey = hospitalSetService.getSignKey(hoscode);

        //加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        //传输过程中“+”转换为了“ ”，因此我们要转换回来
        String logoDataString = (String) paramMap.get("logoData");
        if (!StringUtils.isEmpty(logoDataString)) {
            String logoData = logoDataString.replaceAll(" ", "+");
            paramMap.put("logoData", logoData);
        }


        //调用service的方法
        hospitalService.save(paramMap);
        return Result.ok();
    }
}
