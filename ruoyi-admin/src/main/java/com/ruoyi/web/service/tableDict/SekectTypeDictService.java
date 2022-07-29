package com.ruoyi.web.service.tableDict;

import com.ruoyi.web.mapper.BawBaseCarSeriesMapper;
import com.ruoyi.web.mapper.BawBaseCarTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author sunyun
 * @date 2022年05月31日14:50
 */
@Service("selectTypeDict")
public class SekectTypeDictService {
    @Autowired
    private BawBaseCarTypeMapper bawBaseCarTypeMapper;
    public List<ModelMap> selectType(String code){
        List<ModelMap> modelMaps = bawBaseCarTypeMapper.selectType(code);
        return modelMaps;
    }


    public List<ModelMap> selectCode(String config){
        List<ModelMap> modelMaps = bawBaseCarTypeMapper.selectCode(config);
        return modelMaps;
    }
    /**
     * 根据code获取车型配置信息（小程序专用）
     * @param config
     * @return
     */
    public List<ModelMap> selectCodeApplet(String config){
        List<ModelMap> modelMaps = bawBaseCarTypeMapper.selectCodeApplet(config);
        return modelMaps;
    }
    /**
     * 根据一级车系（carSeriesCode）车型配置获取车型配置信息
     * @param serviceCode
     * @return
     */
    public List<ModelMap> selectBawBaseCarTypeConfigurationAppletByCarSeriesCode(String serviceCode){
        List<ModelMap> modelMaps = bawBaseCarTypeMapper.selectBawBaseCarTypeConfigurationAppletByCarSeriesCode(serviceCode);
        return modelMaps;
    }
}
