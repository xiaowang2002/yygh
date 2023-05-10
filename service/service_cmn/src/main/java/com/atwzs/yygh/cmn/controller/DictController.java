package com.atwzs.yygh.cmn.controller;

import com.atguigu.yygh.model.cmn.Dict;
import com.atwzs.yygh.cmn.service.DictService;
import com.atwzs.yygh.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName DictController
 * @Description
 * @Author WangZhisheng
 * @Date 19:14 2023/5/2
 * @Version 11.0.15
 */
@RestController
@RequestMapping("/admin/cmn/dict")
@Api(value = "数据字典接口")
@CrossOrigin
public class DictController {

    @Resource
    private DictService dictService;

    /**
     * @description: 导出数据字典接口
     **/
    @GetMapping("/exportData")
    public void exportDict(HttpServletResponse response) {
        dictService.exportDict(response);
    }

    /**
     * @description: 导入数据字典
     **/
    @PostMapping("/importData")
    public Result<Object> importDict(MultipartFile file) {
        dictService.importDictData(file);
        return Result.ok();
    }

    /**
     * @description: 根据数据id查询子数据列表
     **/
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("/findChildData/{id}")
    public Result<List<Dict>> findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChildData(id);
        return Result.ok(list);
    }

    @ApiOperation(value = "获取数据字典名称")
    @GetMapping(value = "/getName/{parentDictCode}/{value}")
    public String getName(
            @ApiParam(name = "parentDictCode", value = "上级编码", required = true)
            @PathVariable("parentDictCode") String parentDictCode,

            @ApiParam(name = "value", value = "值", required = true)
            @PathVariable("value") String value) {
        String dictName = dictService.getNameByParentDictCodeAndValue(parentDictCode, value);
        return dictName;
    }

    @ApiOperation(value = "获取数据字典名称")
    @ApiImplicitParam(name = "value", value = "值", required = true, dataType = "Long", paramType = "path")
    @GetMapping(value = "/getName/{value}")
    public String getName(
            @ApiParam(name = "value", value = "值", required = true)
            @PathVariable("value") String value) {
        return dictService.getNameByParentDictCodeAndValue("", value);
    }

    @ApiOperation(value = "根据dictCode获取下级节点")
    @GetMapping(value = "/findByDictCode/{dictCode}")
    public Result<List<Dict>> findByDictCode(
            @ApiParam(name = "dictCode", value = "节点编码", required = true)
            @PathVariable String dictCode) {
        List<Dict> list = dictService.findByDictCode(dictCode);
        return Result.ok(list);
    }


}
