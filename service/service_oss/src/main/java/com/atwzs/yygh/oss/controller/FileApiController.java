package com.atwzs.yygh.oss.controller;

import com.atwzs.yygh.common.result.Result;
import com.atwzs.yygh.oss.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @ClassName FileApiController
 * @Description
 * @Author WangZhisheng
 * @Date 19:48 2023/5/16
 * @Version 11.0.15
 */
@RestController
@RequestMapping("/api/oss/file")
public class FileApiController {

    @Resource
    private FileService fileService;

    //上传文件道阿里云oss
    @PostMapping("fileUpload")
    public Result fileUpload(MultipartFile file) {
        //获取上传文件
        String url = fileService.upload(file);
        return Result.ok(url);
    }
}
