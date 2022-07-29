package com.ruoyi.web.service.tableDict;

import com.ruoyi.web.mapper.BawBaseCarSeriesMapper;
import com.ruoyi.web.mapper.BawBaseCarTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author ruoyi
 * @date 2022年04月08日16:47
 */
@Service("seriesCodeDict")
public class SeriesDictService {
    @Autowired
    private BawBaseCarSeriesMapper bawBaseCarSeriesMapper;
    @Autowired
    private BawBaseCarTypeMapper bawBaseCarTypeMapper;
    public List<ModelMap> getSerierCode(){
        List<ModelMap> modelMaps = bawBaseCarSeriesMapper.selectBawBaseCarSeriesByCode();
        return modelMaps;
    }
    /**
     * 根据一级车系（carSeriesCode）车型配置获取车型配置信息
     * @param config
     * @return
     */
    public List<ModelMap> selectBawBaseCarTypeConfigurationAppletByCarSeriesCode(String config){
        List<ModelMap> modelMaps = bawBaseCarTypeMapper.selectBawBaseCarTypeConfigurationAppletByCarSeriesCode(config);
        return modelMaps;
    }
}
