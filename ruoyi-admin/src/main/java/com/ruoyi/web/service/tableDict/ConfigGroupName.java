package com.ruoyi.web.service.tableDict;

import com.ruoyi.web.mapper.BawBaseCarConfigGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author ruoyi
 * @date 2022年04月11日19:02
 */
@Service("ConfigGroupName")
public class ConfigGroupName {
    @Autowired
    private BawBaseCarConfigGroupMapper bawBaseCarConfigGroupMapper;
    public List<ModelMap> getConfigGroupName() {
        List<ModelMap> modelMaps = bawBaseCarConfigGroupMapper.selectBawBaseCarConfigGroupByName();
        return modelMaps;
    }
    public List<ModelMap> getConfigGroupByName() {
        List<ModelMap> modelMaps = bawBaseCarConfigGroupMapper.selectBawBaseCarConfigGroupName();
        return modelMaps;
    }
}
