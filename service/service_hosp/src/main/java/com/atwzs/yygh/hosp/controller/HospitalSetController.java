package com.atwzs.yygh.hosp.controller;

import com.atguigu.yygh.model.hosp.HospitalSet;
import com.atguigu.yygh.vo.hosp.HospitalSetQueryVo;
import com.atwzs.yygh.common.result.Result;
import com.atwzs.yygh.common.utils.MD5;
import com.atwzs.yygh.hosp.service.HospitalSetService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @ClassName HospitalSetController
 * @Description
 * @Author WangZhisheng
 * @Date 15:41 2023/4/18
 * @Version 11.0.15
 */
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@CrossOrigin
public class HospitalSetController {

    //注入Service
    @Resource
    private HospitalSetService hospitalSetService;

    //查询医院设置表所有信息
    @GetMapping("findAll")
    @ApiOperation("获取所有医院设置")
    public Result<List<HospitalSet>> findAllHospitalSet() {
        //调用service的方法
        return Result.ok(hospitalSetService.list());   //底层用了jackson转换成json格式数据
    }

    //删除医院设置
    @ApiOperation("逻辑删除医院设置")
    @DeleteMapping("{id}")
    public Result<Object> removeHospSet(@PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
    //逻辑删除
    /*@TableLogic注解表示逻辑删除

    效果：在字段上加上这个注解再执行BaseMapper的删除方法时，删除方法会变成修改

    场景：
            1.实体类中属性加上@TableLogic,
    @TableLogic
    private Integer dataStatus;

    2.调用BaseMapper的deleteById(id)或者调用IService的removeById(id)

    效果:
    没有@TableLogic注解调用deleteById/removeById,直接删除数据。
    SQL:delete from table where id = 1
    有注解走Update方法
    SQL：Update table set isDelete = 1 where id = 1

    @TableLogic注解参数
 　　　　value = “” 未删除的值，默认值为0
 　　　　delval = “” 删除后的值，默认值为1
 　　　　@TableLogic(value=”原值”,delval=”改值”)
    扩展
    当使用了@TableLogic注解，调用update方法是并不会将该字段放入修改字段中，而是在条件字段中。即使你给dataStatus赋值也不会修改*/

    //条件查询带分页
    @PostMapping("findPageHospSet/{current}/{limit}")
    public Result<Page<HospitalSet>> findPageHospSet(@PathVariable long current, @PathVariable long limit,
                                                     @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {   //requestBody注解只能用在PostMapping下
        //创建page对象，传递当前页，每页记录数
        Page<HospitalSet> page = new Page<>(current, limit);
        //构建条件
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        if (hospitalSetQueryVo != null) {
            String hosname = hospitalSetQueryVo.getHosname();    //医院名称
            String hoscode = hospitalSetQueryVo.getHoscode();    //医院编号
            //判断
            if (!StringUtils.isEmpty(hosname)) {
                wrapper.like("hosname", hosname);
            }
            if (!StringUtils.isEmpty(hoscode)) {
                wrapper.eq("hoscode", hoscode);
            }
        } else {
            wrapper = null;
        }
        //调用方法，实现分页查询
        Page<HospitalSet> pageHospitalSet = hospitalSetService.page(page, wrapper);
        return Result.ok(pageHospitalSet);
    }

    //添加医院设置
    @PostMapping("saveHospitalSet")
    public Result<Object> saveHospitalSet(@RequestBody HospitalSet hospitalSet) {
        //设置状态，1使用，0不能使用
        hospitalSet.setStatus(1);
        //签名密钥
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis() + "" + random.nextInt(1000)));
        //调用service
        boolean flag = hospitalSetService.save(hospitalSet);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //根据id获取医院设置
    @GetMapping("getHospSet/{id}")
    public Result<HospitalSet> getHospSet(@PathVariable Long id) {
        /*try {
            //模拟异常
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new YyghException("失败", 201);
        }*/
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }

    //修改医院设置
    @PutMapping("updateHospitalSet")
    public Result<Object> updateHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);   //只会改掉hospitalSet存在的值，该对象别的属性不更改
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //批量删除医院设置
    @DeleteMapping("batchRemove")
    public Result<Object> batchRemoveHospitalSet(@RequestBody List<Long> ids) {
        hospitalSetService.removeByIds(ids);
        return Result.ok();
    }

    //医院设置锁定和解锁
    @PutMapping("lockHospitalSet/{id}/{status}")
    public Result<Object> lockHospitalSet(@PathVariable Long id, @PathVariable Integer status) {
        //根据id查询医院设置信息
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        //设置医院状态
        hospitalSet.setStatus(status);
        //调用方法
        hospitalSetService.updateById(hospitalSet);
        return Result.ok();
    }

    //发送签名key
    @PutMapping("sendKey/{id}")
    public Result<Object> lockHospitalSet(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        String hoscode = hospitalSet.getHoscode();
        String hosname = hospitalSet.getHosname();
        //TODO 发送短信
        return Result.ok();
    }
}
