package com.atwzs.yygh.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileService
 * @Description
 * @Author WangZhisheng
 * @Date 19:51 2023/5/16
 * @Version 11.0.15
 */
public interface FileService {
    String upload(MultipartFile file);
}
