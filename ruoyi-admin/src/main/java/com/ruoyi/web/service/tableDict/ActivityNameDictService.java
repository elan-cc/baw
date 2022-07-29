package com.ruoyi.web.service.tableDict;

import com.ruoyi.web.domain.BawActivityWx;
import com.ruoyi.web.mapper.BawActivityWxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author ruoyi
 * @date 2022年03月22日16:11
 */
@Service("activityNameDict")
public class ActivityNameDictService {
    @Autowired
    private BawActivityWxMapper bawActivityWxMapper;
    public List<ModelMap> getActivityName(String tableName){
        List<ModelMap> modelMaps = bawActivityWxMapper.selectBawActivityWxByName(tableName);
        return modelMaps;
    }
}
