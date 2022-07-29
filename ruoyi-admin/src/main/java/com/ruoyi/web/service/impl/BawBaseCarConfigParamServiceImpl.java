package com.ruoyi.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.wx.utils.Utils;
import com.ruoyi.web.domain.BawBaseCarConfigGroup;
import com.ruoyi.web.domain.BawBaseCarConfigParam;
import com.ruoyi.web.domain.BawBaseCarConfigParamDeserialization;
import com.ruoyi.web.domain.BawBaseDealershop;
import com.ruoyi.web.enums.CarConfigEnum;
import com.ruoyi.web.mapper.BawBaseCarConfigGroupMapper;
import com.ruoyi.web.mapper.BawBaseCarConfigParamMapper;
import com.ruoyi.web.service.IBawBaseCarConfigParamService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车型配置参数Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@Service
public class BawBaseCarConfigParamServiceImpl implements IBawBaseCarConfigParamService
{
    @Autowired
    private BawBaseCarConfigParamMapper bawBaseCarConfigParamMapper;
    @Autowired
    private BawBaseCarConfigGroupMapper bawBaseCarConfigGroupMapper;

    /**
     * 查询车型配置参数
     *
     * @param carConfigCode 车型配置编码
     * @return
     */
    @Override
    public BawBaseCarConfigParamDeserialization selectBawBaseCarConfigParamById(String carConfigCode)
    {

        return selectByCode(carConfigCode);
    }

    /**
     * 查询车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 车型配置参数
     */
    @Override
    public List<BawBaseCarConfigParam> selectBawBaseCarConfigParamList(BawBaseCarConfigParam bawBaseCarConfigParam) {
        /*List<String> code = bawBaseCarConfigParamMapper.selectCode(bawBaseCarConfigParam);

        List<BawBaseCarConfigParamDeserialization> bawBaseCarConfigParamDeserializationList = new ArrayList<>();
        for (String s : code) {
            bawBaseCarConfigParamDeserializationList.add(selectByCode(s));
        }*/
        List<BawBaseCarConfigParam> bawBaseCarConfigParamList = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamList(bawBaseCarConfigParam);
        return bawBaseCarConfigParamList;
    }
    /**
     * 查询车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 车型配置参数
     */
    @Override
    public List<BawBaseCarConfigParam> selectBawBaseCarConfigParamPageList(BawBaseCarConfigParam bawBaseCarConfigParam) {
//        List<String> code = bawBaseCarConfigParamMapper.selectCode(bawBaseCarConfigParam);

//        List<BawBaseCarConfigParamDeserialization> bawBaseCarConfigParamDeserializationList = new ArrayList<>();
//        for (String s : code) {
//            bawBaseCarConfigParamDeserializationList.add(selectByCode(s));
//        }
        List<BawBaseCarConfigParam> bawBaseCarConfigParamList = bawBaseCarConfigParamMapper.selecList(bawBaseCarConfigParam);
        return bawBaseCarConfigParamList;
    }
    /**
     * 查询车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 车型配置参数
     */
    @Override
    public List<BawBaseCarConfigParam> selectBawBaseCarConfigList(BawBaseCarConfigParam bawBaseCarConfigParam) {
        List<BawBaseCarConfigParam> bawBaseCarConfigParamList = bawBaseCarConfigParamMapper.selecListOreder(bawBaseCarConfigParam);
        return bawBaseCarConfigParamList;
    }

    /**
     * 根据车型编码来查询其所有参数
     * @param carConfigCode 车型编码
     * @return
     */
    private BawBaseCarConfigParamDeserialization selectByCode(String carConfigCode){
        BawBaseCarConfigParamDeserialization baseCarConfigParamDeserialization = new BawBaseCarConfigParamDeserialization();
        BawBaseCarConfigParam selectCode = new BawBaseCarConfigParam();
        selectCode.setCarConfigCode(carConfigCode);
        List<BawBaseCarConfigParam> paramList = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamList(selectCode);
        if (paramList.size() > 0) {
            for (BawBaseCarConfigParam b : paramList) {
                baseCarConfigParamDeserialization.setCarConfigCode(b.getCarConfigCode());
                baseCarConfigParamDeserialization.setCarSeriesCode(b.getCarSeriesCode());
                Field[] field = baseCarConfigParamDeserialization.getClass().getDeclaredFields();
                for (int i = 0; i < field.length; i++) {
                    if (field[i].getName().equals(b.getParamCode())) {
                        try {
                            field[i].setAccessible(true);
                            field[i].set(baseCarConfigParamDeserialization, b.getParamValue());
                            field[i].setAccessible(false);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return baseCarConfigParamDeserialization;
    }
    /**
     * 新增车型配置参数
     *
     * @param baseCarConfigParamDeserialization 车型配置参数
     * @return 结果
     */
    @Override
    public int insertBawBaseCarConfigParam(BawBaseCarConfigParamDeserialization baseCarConfigParamDeserialization) {
        BawBaseCarConfigParam bawBaseCarConfigParam =new BawBaseCarConfigParam();
        bawBaseCarConfigParam.setCarConfigCode(baseCarConfigParamDeserialization.getCarConfigCode());
        int count = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamCount(bawBaseCarConfigParam);
        if (count>0){
            return 0;
        }
        List<BawBaseCarConfigParam> bawBaseCarConfigParamList = toEntity(baseCarConfigParamDeserialization,0);
        for (BawBaseCarConfigParam b : bawBaseCarConfigParamList) {
            bawBaseCarConfigParamMapper.insertBawBaseCarConfigParam(b);
        }
        return 1;
    }
    /**
     * 新增车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 结果
     */
    @Override
    public int insertBawBaseCarConfigParams(BawBaseCarConfigParam bawBaseCarConfigParam) {
        int count = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamCounts(bawBaseCarConfigParam);
        if (count != 0) {
            return 0;
        }
        if (Utils.configCode(bawBaseCarConfigParam.getCarConfigCode())){
            return 3;
        }
        bawBaseCarConfigParamMapper.insertBawBaseCarConfigParam(bawBaseCarConfigParam);
        return 1;
    }

    /**
     * 修改车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 结果
     */
    @Override
    public int updateBawBaseCarConfigParam(BawBaseCarConfigParam bawBaseCarConfigParam) {
        BawBaseCarConfigParam baseCarConfigParam = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamById(bawBaseCarConfigParam.getId());
        List<BawBaseCarConfigParam> bawBaseCarConfigParams = bawBaseCarConfigParamMapper.selectEdit(baseCarConfigParam);
        for (BawBaseCarConfigParam carConfigParam : bawBaseCarConfigParams) {
            carConfigParam.setCarTypeCode(baseCarConfigParam.getCarTypeCode());
            carConfigParam.setCarSeriesCode(baseCarConfigParam.getCarSeriesCode());
            carConfigParam.setCarConfigCode(baseCarConfigParam.getCarConfigCode());
            bawBaseCarConfigParamMapper.updateBawBaseCarConfig(carConfigParam);
        }
        int count = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamCounts(bawBaseCarConfigParam);
        if (count != 0) {
            return 0;
        }
        bawBaseCarConfigParamMapper.updateBawBaseCarConfigParam(bawBaseCarConfigParam);
        return 1;
    }
    /**
     * 修改车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 结果
     */
    @Override
    public int updateBawBaseCarConfig(BawBaseCarConfigParam bawBaseCarConfigParam) {
        int count = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamCounts(bawBaseCarConfigParam);
        if (count != 0) {
            return 0;
        }
        BawBaseCarConfigParam baseCarConfigParam = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamById(bawBaseCarConfigParam.getId());
        List<BawBaseCarConfigParam> bawBaseCarConfigParams = bawBaseCarConfigParamMapper.selectEdit(baseCarConfigParam);
        for (BawBaseCarConfigParam carConfigParam : bawBaseCarConfigParams) {
            carConfigParam.setCarTypeCode(bawBaseCarConfigParam.getCarTypeCode());
            carConfigParam.setCarSeriesCode(bawBaseCarConfigParam.getCarSeriesCode());
            carConfigParam.setCarConfigCode(bawBaseCarConfigParam.getCarConfigCode());
            bawBaseCarConfigParamMapper.updateBawBaseCarConfig(carConfigParam);
        }

        bawBaseCarConfigParamMapper.updateBawBaseCarConfig(bawBaseCarConfigParam);
        return 1;
    }


    /**
     * 批量删除车型配置参数
     *
     * @param ids 需要删除的车型配置参数主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarConfigParamByIds(String ids)
    {
        return bawBaseCarConfigParamMapper.deleteBawBaseCarConfigParamByIds(Convert.toStrArray(ids));
    }    /**
     * 批量删除车型配置参数
     *
     * @param carConfigCode 车型编码
     * @param paramName 配置名称
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarConfigParamByname(String carConfigCode, String paramName)
    {
        return bawBaseCarConfigParamMapper.deleteBawBaseCarConfigParamByname(carConfigCode, paramName);
    }

    /**
     * 删除车型配置参数信息
     *
     * @param id 车型配置参数主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarConfigParamById(Integer id)
    {
        BawBaseCarConfigParam baseCarConfigParam = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamById(id);
        if (baseCarConfigParam.getParamName().equals("0")){
            return bawBaseCarConfigParamMapper.deleteBawBaseCarList(baseCarConfigParam);
        }else {
            return bawBaseCarConfigParamMapper.deleteBawBaseCarConfigParamById(id);
        }
    }


    /**
     * 通过车系id 查询相关车系所有配置
     *
     * @param ids 车系id集合，传空则为查全部
     * @return
     */
    @Override
    public AjaxResult queryConfigurationById(String ids) {
        // 用于封装返回参数 key:车系编号
        Map<String,Map> resultMap = new HashMap<>();
        // 查询车型配置参数
        List<BawBaseCarConfigParam> params = bawBaseCarConfigParamMapper.queryConfigurationById(StringUtils.isBlank(ids)?null : Convert.toStrArray(ids));
        for (BawBaseCarConfigParam configparam : params) {
            // key: 参数名
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(configparam.getParamName(), configparam.getParamValue());

            boolean b = resultMap.containsKey(configparam.getCarConfigCode());
            if (!b){
                // key：参数code
                Map<String, Map> carConfigCodeMap = new HashMap<>();
                carConfigCodeMap.put(configparam.getParamCode(), paramMap);
                resultMap.put(configparam.getCarConfigCode(),carConfigCodeMap);
            } else {
                resultMap.get(configparam.getCarConfigCode()).put(configparam.getParamCode(), paramMap);
            }
        }
        System.out.println(resultMap);
        return AjaxResult.success("查询成功",resultMap);
    }

    /**
     * 通过车系编码查询配置
     * @param carSeriesCode 车系编码
     * @return
     */
    @Override
    public AjaxResult queryBycarSeriesCode(String carSeriesCode) {
        // 用于封装返回参数 key:车系编号
        Map<String,Map> resultMap = new HashMap<>();
        List<BawBaseCarConfigParam> params = bawBaseCarConfigParamMapper.queryBycarSeriesCode(carSeriesCode);
        for (BawBaseCarConfigParam configparam : params) {
            // key: 参数名
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(configparam.getParamName(), configparam.getParamValue());

            boolean b = resultMap.containsKey(configparam.getCarConfigCode());
            if (!b){
                // key：参数code
                Map<String, Map> carConfigCodeMap = new HashMap<>();
                carConfigCodeMap.put(configparam.getParamCode(), paramMap);
                resultMap.put(configparam.getCarConfigCode(),carConfigCodeMap);
            } else {
                resultMap.get(configparam.getCarConfigCode()).put(configparam.getParamCode(), paramMap);
            }
        }
        System.out.println(resultMap);
        return AjaxResult.success("查询成功",resultMap);
    }

    /**
     * 通过车系编码查询数量
     * @param bawBaseCarConfigParam 车量信息实体
     * @return
     */
    @Override
    public int selectBawBaseCarConfigParamCount(BawBaseCarConfigParam bawBaseCarConfigParam) {
        int count = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamCount(bawBaseCarConfigParam);
        return count;
    }

    /**
     * 导入车辆配置信息
     *
     * @param bawBaseCarConfigParams 车辆配置信息列表
     * @param loginName 操作用户
     * @return 结果
     */
    @Override
    public String importBawBaseCarConfigParam(List<BawBaseCarConfigParam> bawBaseCarConfigParams, String loginName) {
       if (StringUtils.isNull(bawBaseCarConfigParams) || bawBaseCarConfigParams.size() == 0) {
           throw new ServiceException("导入车辆配置信息不能为空！");
       }
       for (BawBaseCarConfigParam bawBaseCarConfigParam: bawBaseCarConfigParams){
           int count = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamCount(bawBaseCarConfigParam);
           if (count == 0){
               BawBaseCarConfigParam configParam = new BawBaseCarConfigParam();
               configParam.setCarSeriesCode(bawBaseCarConfigParam.getCarSeriesCode());
               configParam.setCarConfigCode(bawBaseCarConfigParam.getCarConfigCode());
               configParam.setParamValue("0");
               configParam.setParamName("0");
               configParam.setConfigGroupId(0);
               configParam.setOrderNum(0);
               bawBaseCarConfigParamMapper.insertBawBaseCarConfigParam(configParam);
           }
           BawBaseCarConfigGroup bawBaseCarConfigGroup1 = bawBaseCarConfigGroupMapper.selectBawBaseCarConfigGroupname(bawBaseCarConfigParam.getConfigGroup());
           if (bawBaseCarConfigGroup1 == null){
               BawBaseCarConfigGroup bawBaseCarConfigGroup = new BawBaseCarConfigGroup();
               bawBaseCarConfigGroup.setName(bawBaseCarConfigParam.getConfigGroup());
               bawBaseCarConfigGroupMapper.insertBawBaseCarConfigGroup(bawBaseCarConfigGroup);
           }
           BawBaseCarConfigParam baseCarConfig = bawBaseCarConfigParamMapper.selectValue(bawBaseCarConfigParam);
           int scount = bawBaseCarConfigParamMapper.selectCounts(bawBaseCarConfigParam);
           if (scount != 0) {
               return "0";
           }
           if (baseCarConfig == null){
//               baseCarConfig = new BawBaseCarConfigParam();
//               baseCarConfig.setParamValue(bawBaseCarConfigParam.getParamValue());
               bawBaseCarConfigParam.setConfigGroupId(bawBaseCarConfigGroup1.getId());
               bawBaseCarConfigParamMapper.insertBawBaseCarConfigParam(bawBaseCarConfigParam);
           } else {

               bawBaseCarConfigParam.setConfigGroupId(bawBaseCarConfigGroup1.getId());
               bawBaseCarConfigParamMapper.updateBawBaseCarConfigParamExcil(bawBaseCarConfigParam);
           }
       }
       return "导入成功";
    }


    /**
     * 转为数据库存储实体
     * @param baseCarConfigParamDeserialization HTML接受实体
     * @return
     */
    private List<BawBaseCarConfigParam> toEntity(BawBaseCarConfigParamDeserialization baseCarConfigParamDeserialization,int status) {
        System.out.println();
        List<BawBaseCarConfigParam> bawBaseCarConfigParamList = new ArrayList<>();
        //循环'字段数量'次
        for (int i = 0; i < baseCarConfigParamDeserialization.getClass().getDeclaredFields().length; i++) {
            String fieldName = baseCarConfigParamDeserialization.getClass().getDeclaredFields()[i].getName();
            if (fieldName == "carConfigCode" || fieldName == "carSeriesCode") {
                continue;
            }
            String name = CarConfigEnum.getNameByCode(fieldName);
            BawBaseCarConfigParam bawBaseCarConfigParam = new BawBaseCarConfigParam();
            bawBaseCarConfigParam.setCarConfigCode(baseCarConfigParamDeserialization.getCarConfigCode());
            bawBaseCarConfigParam.setCarSeriesCode(baseCarConfigParamDeserialization.getCarSeriesCode());
            bawBaseCarConfigParam.setParamName(name);
            bawBaseCarConfigParam.setParamCode(fieldName);
            bawBaseCarConfigParam.setParamValue(String.valueOf(getFieldValueByName(fieldName, baseCarConfigParamDeserialization)));
            if (status == 0) {
                if (StringUtils.isNotEmpty(bawBaseCarConfigParam.getParamValue())) {
                    bawBaseCarConfigParamList.add(bawBaseCarConfigParam);
                }
            }
            if (status == 1) {
                bawBaseCarConfigParamList.add(bawBaseCarConfigParam);
            }
        }
        return bawBaseCarConfigParamList;
    }
    /**
     * 根据属性名获取属性值
     */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            Object value = method.invoke(o);
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage() + e);
            return null;
        }
    }


    /**
     * 通过车系编号查询配置
     * @param carSeriesCode 车系编号
     * @return
     */
    @Override
    public AjaxResult queryConfig(String carSeriesCode) {
        // 封装返回值：[{"carConfigCode" : "车型配置编码", "carParams" : [车型配置分组] }]
        List<Map<String, Object>> resultList = new ArrayList<>();
        // 通过车系查询配置表中的所有 配置编码
        List<ModelMap> modelMaps = bawBaseCarConfigParamMapper.selectCarConfigCode(carSeriesCode);
        for (ModelMap modelMap : modelMaps) {
            JSONObject map = new JSONObject();
            map.put("carConfigCode",modelMap.get("car_config_code"));
            map.put("carParams", new ArrayList<Object>());
            resultList.add(map);
        }
        List<ModelMap> paramCopies = bawBaseCarConfigParamMapper.selectLeftJoinConfigGroup(carSeriesCode);
        // 循环查出的所有车型配置信息
        for (ModelMap modelMap : paramCopies) {
            if (StringUtils.isNull(modelMap.get("name"))){
                System.err.println("name is null : " + modelMap);
                continue;
            }
            String carConfigCode = (String) modelMap.get("car_config_code");
            // 整体返回值 resultList:[{"carConfigCode" : "车型配置编码", "carParams" : [车型配置分组集合] }]
            for (Map<String, Object> objectMap : resultList) {
                if(objectMap.get("carConfigCode").equals(carConfigCode)){
                    boolean b = false;
                    // 车型配置分组集合 carParams:[{"name":"分组名称","params":[车型配置集合]}]
                    List carParams = castList(objectMap.get("carParams"),Object.class);
                    for (int i = 0; i < carParams.size(); i++) {
                        // 车型配置分组 carParamMap:{"name":"分组名称","params":[车型配置集合]}
                        Map<String, Object> carParamMap = JSONObject.parseObject(JSON.toJSONString(carParams.get(i)));
                        // 车型配置所属车型配置分组 equals 返回参数中车型配置分组
                        if (modelMap.get("name").equals(carParamMap.get("name"))){
                            b = true;
                            // 车型配置集合 params:[{"配置名称":"配置属性值"}]
                            List params = castList(carParamMap.get("params"),Object.class);
                            Map<String, Object> paramMap = new HashMap<>();
                            paramMap.put("name", modelMap.get("param_name"));
                            paramMap.put("value", modelMap.get("param_value"));
                            params.add(paramMap);
                            carParams.remove(i);
                            carParamMap.put("params", params);
                            carParams.add(carParamMap);
                            objectMap.put("carParams", carParams);
                            break;
                        }
                    }
                    // 车型配置所属车型配置分组 !equals 返回参数中车型配置分组
                    if (!b) {
                        Map<String, Object> carParamMap = new HashMap<>();
                        carParamMap.put("name", modelMap.get("name"));
                        List<Map<String, Object>> params = new ArrayList<>();
                        Map<String, Object> paramMap = new HashMap<>();
                        paramMap.put("name", modelMap.get("param_name"));
                        paramMap.put("value", modelMap.get("param_value"));
                        params.add(paramMap);
                        carParamMap.put("params", params);
                        carParams.add(carParamMap);
                        objectMap.put("carParams", carParams);
                    }
                }
            }
        }

        return AjaxResult.success("查询成功！",resultList);
    }

    @Override
    public BawBaseCarConfigParam selectById(Integer id) {
        BawBaseCarConfigParam bawBaseCarConfigParam = bawBaseCarConfigParamMapper.selectBawBaseCarConfigParamById(id);
        return bawBaseCarConfigParam;
    }

    @Override
    public int deleteBawBaseCarConfigParamByCarConfigCode(String carConfigCode) {

        return bawBaseCarConfigParamMapper.deleteBawBaseCarConfigParamByCarConfigCode(carConfigCode);
    }

    /**
     * object 转 List
     * @param obj 需要转换的List对象
     * @param clazz List中元素的class
     * @param <T>
     * @return
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz)
    {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
