package com.ruoyi.web.service.tableDict;

import com.ruoyi.web.mapper.BawCommodityClassifyWxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author ruoyi
 * @date 2022年05月11日16:37
 */
@Service("classifyByName")
public class ClassifyNameService {
    @Autowired
    private BawCommodityClassifyWxMapper bawCommodityClassifyWxMapper;
    public List<ModelMap> getClassifyByName() {
        List<ModelMap> modelMaps = bawCommodityClassifyWxMapper.selectBawCommodityClassifyWxByName();
        return modelMaps;
    }
    public List<ModelMap> getSelectById() {
        List<ModelMap> modelMap = bawCommodityClassifyWxMapper.selectById();
        return modelMap;
    }
}
