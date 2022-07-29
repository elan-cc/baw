package com.ruoyi.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawBaseDealershop;
import com.ruoyi.web.mapper.BawBaseDealershopMapper;
import com.ruoyi.web.service.IBawBaseDealershopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

/**
 * 门店信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class BawBaseDealershopServiceImpl implements IBawBaseDealershopService
{
    @Autowired
    private BawBaseDealershopMapper bawBaseDealershopMapper;

    /**
     * 查询门店信息
     *
     * @param id 门店信息主键
     * @return 门店信息
     */
    @Override
    public BawBaseDealershop selectBawBaseDealershopById(Integer id)
    {
        return bawBaseDealershopMapper.selectBawBaseDealershopById(id);
    }

    /**
     * 查询门店信息列表
     *
     * @param bawBaseDealershop 门店信息
     * @return 门店信息
     */
    @Override
    public List<BawBaseDealershop> selectBawBaseDealershopList(BawBaseDealershop bawBaseDealershop)
    {
        return bawBaseDealershopMapper.selectBawBaseDealershopList(bawBaseDealershop);
    }

    /**
     * BAW查询门店信息列表
     *
     * @param
     * @return 门店信息
     */
    @Override
    public List<BawBaseDealershop> selectBawBaseDealershopListForBAW(BawBaseDealershop bawBaseDealershop) {
        return bawBaseDealershopMapper.selectBawBaseDealershopListForBAW(bawBaseDealershop);
    }

    /**
     * 小程序查询门店信息列表，并通过坐标点计算距离
     * @param bawBaseDealershop 门店信息
     * @param location 经纬度 格式：lat<纬度>,lng<经度>，例：39.984154,116.307490
     * @return 门店信息集合
     */
    @Override
    public Map<String, Object> selectBawBaseDealershopListForBAW(BawBaseDealershop bawBaseDealershop, String location) {
        Map<String, Object> resutlMap = new HashMap<>();
        List<String> locations = new ArrayList<>();
        List<BawBaseDealershop> bawBaseDealershops = bawBaseDealershopMapper.selectBawBaseDealershopListForBAW(bawBaseDealershop);
        int count = bawBaseDealershopMapper.selectBawBaseDealershopListForBAWCount(bawBaseDealershop);
        resutlMap.put("count", count);
        for (BawBaseDealershop baseDealershop : bawBaseDealershops) {
            if (StringUtils.isNotBlank(baseDealershop.getLat()) && StringUtils.isNotBlank(baseDealershop.getLng())){
                locations.add(String.format("%s,%s", baseDealershop.getLat(),baseDealershop.getLng()));
            }
        }
        List<Integer> resultList = batchDistanceCalculation(location, locations);
        if (null == resultList || resultList.size() == 0){
            // 查询距离失败，直接返回
            resutlMap.put("result", bawBaseDealershops);
            return resutlMap;
        }
        for (BawBaseDealershop baseDealershop : bawBaseDealershops) {
            if (StringUtils.isNotBlank(baseDealershop.getLat()) && StringUtils.isNotBlank(baseDealershop.getLng())){
                String coordinate = String.format("%s,%s", baseDealershop.getLat(),baseDealershop.getLng());
                if (locations.contains(coordinate)){
                    int i = locations.indexOf(coordinate);
                    baseDealershop.setDistance(resultList.get(i));
                }
            }
        }
        resutlMap.put("result", bawBaseDealershops);
        return resutlMap;
    }

    /**
     * 新增门店信息
     *
     * @param bawBaseDealershop 门店信息
     * @return 结果
     */
    @Override
    public int insertBawBaseDealershop(BawBaseDealershop bawBaseDealershop)
    {
        bawBaseDealershop.setCreateTime(DateUtils.getNowDate());
        return bawBaseDealershopMapper.insertBawBaseDealershop(bawBaseDealershop);
    }

    /**
     * 修改门店信息
     *
     * @param bawBaseDealershop 门店信息
     * @return 结果
     */
    @Override
    public int updateBawBaseDealershop(BawBaseDealershop bawBaseDealershop)
    {
        bawBaseDealershop.setUpdateTime(DateUtils.getNowDate());
        return bawBaseDealershopMapper.updateBawBaseDealershop(bawBaseDealershop);
    }

    /**
     * 批量删除门店信息
     *
     * @param ids 需要删除的门店信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseDealershopByIds(Integer[] ids)
    {
        return bawBaseDealershopMapper.deleteBawBaseDealershopByIds(ids);
    }

    /**
     * 删除门店信息信息
     *
     * @param id 门店信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseDealershopById(Integer id)
    {
        return bawBaseDealershopMapper.deleteBawBaseDealershopById(id);
    }
    /**
     * 查询门店信息信息
     *
     * @param dlrCode 门店信息主键
     * @return 结果
     */
    public List<BawBaseDealershop>  selectBawBaseDealershopByDlrCode(String dlrCode)
    {
        return bawBaseDealershopMapper.selectBawBaseDealershopByDlrCode(dlrCode);
    }


    @Override
    public String importBawBaseDealershop(List<BawBaseDealershop> bawBaseDealershopList, String loginName) {
        if (StringUtils.isNull(bawBaseDealershopList) || bawBaseDealershopList.size() == 0) {
            throw new ServiceException("导入经销商信息不能为空！");
        }
        for (BawBaseDealershop bawBaseDealershop: bawBaseDealershopList){
            bawBaseDealershopMapper.updateBawBaseDealershopExcil(bawBaseDealershop);
        }
        return "导入成功";
    }

    /**
     * 批量距离计算
     * @param location 起始坐标，格式：lat<纬度>,lng<经度>
     * @param locations 终点坐标集合
     * @return
     */
    public List<Integer> batchDistanceCalculation(String location, List<String> locations){
        List<Integer> resultList = new ArrayList<>();
        String key = "IF2BZ-QU7E3-ZHI33-Y62T5-HP6IS-FNBIT";
        String to = "";
        for (int i = 0; i < locations.size(); i++) {
            if (i == 0){
                to += locations.get(i);
            } else {
                to += ";" + locations.get(i);
            }
        }
        String url = String.format("https://apis.map.qq.com/ws/distance/v1/matrix/?mode=driving&from=%s&to=%s&key=%s",location,to,key);
        System.out.println("url = " + url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String resultBody = forEntity.getBody();
        // 解析返回值
        JSONObject jsonObject = JSONObject.parseObject(resultBody);
        Integer status = jsonObject.getInteger("status");
        System.out.println("status = " + status);
        if (0 == status) {
            JSONArray rows = jsonObject.getJSONObject("result").getJSONArray("rows");
            if (rows.size() == 0){
                System.err.println("错误");
            }
            JSONArray elements = rows.getJSONObject(0).getJSONArray("elements");
            for (int i = 0; i < elements.size(); i++) {
                JSONObject element = elements.getJSONObject(i);
                Integer distance = element.getInteger("distance");
                resultList.add(distance);
            }
            return resultList;
        } else {
            return null;
        }
    }
}
