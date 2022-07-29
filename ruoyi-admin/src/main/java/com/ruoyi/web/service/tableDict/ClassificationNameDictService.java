package com.ruoyi.web.service.tableDict;

import com.ruoyi.web.mapper.BawActivityClassificationMapper;
import com.ruoyi.web.mapper.BawBaseCarSeriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author sunyun
 * @date 2022年05月25日15:47
 */
@Service("classificationNameDict")
public class ClassificationNameDictService {
    @Autowired
    private BawActivityClassificationMapper bawActivityClassificationMapper;
    public List<ModelMap> getClassificationName(){
        List<ModelMap> modelMaps = bawActivityClassificationMapper.selectBawActivityClassificationByName();
        return modelMaps;
    }
}
