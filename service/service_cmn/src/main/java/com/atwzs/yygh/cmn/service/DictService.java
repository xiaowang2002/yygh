package com.atwzs.yygh.cmn.service;

import com.atguigu.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName DictService
 * @Description
 * @Author WangZhisheng
 * @Date 19:12 2023/5/2
 * @Version 11.0.15
 */
public interface DictService extends IService<Dict> {
    List<Dict> findChildData(Long id);

    void exportDict(HttpServletResponse response);

    void importDictData(MultipartFile multipartFile);

    String getNameByParentDictCodeAndValue(String parentDictCode, String value);

    Dict getByDictsCode(String parentDictCode);

    List<Dict> findByDictCode(String dictCode);
}
