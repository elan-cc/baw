package com.ruoyi.web.service.tableDict;

import com.ruoyi.web.mapper.BawBaseDealershopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author ruoyi
 * @date 2022年03月24日13:40
 */
@Service("shopNameDict")
public class DeakerShopNameDictService {
    @Autowired
    private BawBaseDealershopMapper bawBaseDealershopMapper;

    public List<ModelMap> getDeakerShopName(String tableName){
        List<ModelMap> modelMaps = bawBaseDealershopMapper.selectBawBaseDealershopByName(tableName);
        return modelMaps;
    }

    public List<ModelMap> getDeakerShopCity(String cityc){
        List<ModelMap> modelMaps = bawBaseDealershopMapper.selectBawBaseDealershopByCity(cityc);
        return modelMaps;
    }

    public List<ModelMap> getSelectName(){
        List<ModelMap> modelMaps = bawBaseDealershopMapper.selectBawBaseDealershop();
        return modelMaps;
    }
}
