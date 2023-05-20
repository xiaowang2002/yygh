package com.atwzs.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

/**
 * @ClassName OssTest
 * @Description
 * @Author WangZhisheng
 * @Date 19:38 2023/5/16
 * @Version 11.0.15
 */
public class OssTest {
    public static void main(String[] args) {
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI5tKKrB1MArqekt46Jzpq";
        String accessKeySecret = "zqZdH4k2ZfPtg5XgDXsn996N9P8ajD";
        String bucketName = "yygh-testssss";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.createBucket(bucketName);
        ossClient.shutdown();
    }
}
