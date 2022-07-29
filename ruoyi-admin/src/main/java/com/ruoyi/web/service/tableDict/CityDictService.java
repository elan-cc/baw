package com.ruoyi.web.service.tableDict;


import com.ruoyi.web.mapper.BawCitysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;


/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 *
 * @author ruoyi
 */
@Service("cityDict")
public class CityDictService {

    @Autowired
    private BawCitysMapper bawCitysMapper;

    /**
     * HTML通过字典获取城市表
     *
     * @return
     */
    public List<ModelMap> getProvinceName() {
//        List<ModelMap> bawCitysList = bawCitysMapper.selectProvinceForApi(0, 0);
//        ModelMap modelMap = new ModelMap();
//        modelMap.put("province","全国");
//        modelMap.put("province_code","0");
//        modelMap.put("city","-");
//        modelMap.put("city_code","01");
//        bawCitysList.add(modelMap);
//        return bawCitysList;
        List<ModelMap> modelMaps = new ArrayList<>();
        ModelMap modelMap = new ModelMap();
        modelMap.put("province","全国");
        modelMap.put("province_code","0");
        modelMap.put("city","-");
        modelMap.put("city_code","01");
        modelMaps.add(modelMap);
        List<ModelMap> bawCitysList = bawCitysMapper.selectProvinceForApi(0, 0);
        modelMaps.addAll(bawCitysList);
        return modelMaps;
    }

    /**
     * HTML通过字典获取城市表
     *
     * @return
     */
    public List<ModelMap> getCityName(String provinceCode) {
        String province = bawCitysMapper.selectBawProvinceByCode(provinceCode);
        List<ModelMap> bawCitysList = bawCitysMapper.selectCityForApi(0, 0, province);
        return bawCitysList;
    }

}
