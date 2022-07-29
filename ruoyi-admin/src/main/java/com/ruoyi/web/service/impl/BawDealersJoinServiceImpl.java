package com.ruoyi.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawDealersJoinMapper;
import com.ruoyi.web.domain.BawDealersJoin;
import com.ruoyi.web.service.IBawDealersJoinService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

/**
 * 经销商加盟Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-15
 */
@Service
public class BawDealersJoinServiceImpl implements IBawDealersJoinService
{
    @Autowired
    private BawDealersJoinMapper bawDealersJoinMapper;

    /**
     * 查询经销商加盟
     *
     * @param id 经销商加盟主键
     * @return 经销商加盟
     */
    @Override
    public BawDealersJoin selectBawDealersJoinById(Integer id)
    {
        return bawDealersJoinMapper.selectBawDealersJoinById(id);
    }

    /**
     * 查询经销商加盟列表
     *
     * @param bawDealersJoin 经销商加盟
     * @return 经销商加盟
     */
    @Override
    public List<BawDealersJoin> selectBawDealersJoinList(BawDealersJoin bawDealersJoin)
    {
        return bawDealersJoinMapper.selectBawDealersJoinList(bawDealersJoin);
    }

    /**
     * 查询经销商加盟列表For API
     *
     * @return 经销商加盟集合
     */
    @Override
    public List<ModelMap> selectBawDealersJoinListForApi(Integer isDelete, Integer isDisable, String province, String city, String keywords) {
        return bawDealersJoinMapper.selectBawDealersJoinListForApi(isDelete, isDisable, province, city, keywords);
    }

    /**
     * 新增经销商加盟
     *
     * @param bawDealersJoin 经销商加盟
     * @return 结果
     */
    @Override
    public int insertBawDealersJoin(BawDealersJoin bawDealersJoin)
    {
        return bawDealersJoinMapper.insertBawDealersJoin(bawDealersJoin);
    }

    /**
     * 修改经销商加盟
     *
     * @param bawDealersJoin 经销商加盟
     * @return 结果
     */
    @Override
    public int updateBawDealersJoin(BawDealersJoin bawDealersJoin)
    {
        return bawDealersJoinMapper.updateBawDealersJoin(bawDealersJoin);
    }

    /**
     * 批量删除经销商加盟
     *
     * @param ids 需要删除的经销商加盟主键
     * @return 结果
     */
    @Override
    public int deleteBawDealersJoinByIds(String ids)
    {
        return bawDealersJoinMapper.deleteBawDealersJoinByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除经销商加盟信息
     *
     * @param id 经销商加盟主键
     * @return 结果
     */
    @Override
    public int deleteBawDealersJoinById(Integer id)
    {
        return bawDealersJoinMapper.deleteBawDealersJoinById(id);
    }
    
    /**
     * 调取腾讯api，根据传入的地址查询坐标点
     * @param address 地址（注：地址中请包含城市名称，否则会影响解析效果）
     */
    @Override
    public Map<String,Double> findCoordinatesByAddress(String address){
        Map<String,Double> result = new HashMap<>();
        String key = "IF2BZ-QU7E3-ZHI33-Y62T5-HP6IS-FNBIT";
        String url = String.format("https://apis.map.qq.com/ws/geocoder/v1/?address=%s&key=%s", address, key);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String resultBody = forEntity.getBody();
        // 解析返回值
        JSONObject jsonObject = JSONObject.parseObject(resultBody);
        Integer status = jsonObject.getInteger("status");
        if (0 == status){
            JSONObject lacation = jsonObject.getJSONObject("result").getJSONObject("location");
            // 纬度
            Double lng = lacation.getDouble("lng");
            // 经度
            Double lat = lacation.getDouble("lat");
            result.put("lng", lng);
            result.put("lat", lat);
            return result;
        } else {
            return null;
        }
    }
    
    /**
     * 逆地址解析（根据坐标查询地址）
     * @param location 经纬度 格式：lat<纬度>,lng<经度>
     * @return
     */
    @Override
    public Map<String, Object> findAddressByCoordinates(String location) {
        Map<String, Object> resultMap = new HashMap<>();
        String key = "IF2BZ-QU7E3-ZHI33-Y62T5-HP6IS-FNBIT";
        //https://apis.map.qq.com/ws/geocoder/v1/?location=39.984154,116.307490&key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&get_poi=1
        String url = String.format("https://apis.map.qq.com/ws/geocoder/v1/?location=%s&key=%s&get_poi=0", location, key);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String resultBody = forEntity.getBody();
        // 解析返回值
        JSONObject jsonObject = JSONObject.parseObject(resultBody);
        Integer status = jsonObject.getInteger("status");
        System.out.println("status = " + status);
        if (0 == status) {
            JSONObject result = jsonObject.getJSONObject("result");
            JSONObject location1 = result.getJSONObject("location");
            // 纬度
            Double lng = location1.getDouble("lng");
            // 经度
            Double lat = location1.getDouble("lat");
            resultMap.put("lng", lng);
            resultMap.put("lat", lat);
            // 	以行政区划+道路+门牌号等信息组成的标准格式化地址
            String address = result.getString("address");
            resultMap.put("address", address);
            // 推荐使用的地址描述
            String recommend = result.getJSONObject("formatted_addresses").getString("recommend");
            resultMap.put("recommend", recommend);
            JSONObject address_component = result.getJSONObject("address_component");
            // 国家
            String nation = address_component.getString("nation");
            resultMap.put("nation", nation);
            // 省
            String province = address_component.getString("province");
            resultMap.put("province", province);
            // 市
            String city = address_component.getString("city");
            resultMap.put("city", city);
            // 区，可能为空串
            String district = address_component.getString("district");
            resultMap.put("district", district);
            // 街道，可能为空串
            String street = address_component.getString("street");
            resultMap.put("street", street);
            // 门牌，可能为空串
            String street_number = address_component.getString("street_number");
            resultMap.put("street_number", street_number);
            // 城市编码
            String adcode = result.getJSONObject("ad_info").getString("adcode");
            String cityCode = adcode.substring(0, adcode.length()-2);
            resultMap.put("cityCode",cityCode);
            return resultMap;
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {
        Map<String,Object> resultMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        String key = "IF2BZ-QU7E3-ZHI33-Y62T5-HP6IS-FNBIT";
        // String url = String.format("https://apis.map.qq.com/ws/geocoder/v1/?address=%s&key=%s", "北京", key);
        // String url = String.format("https://apis.map.qq.com/ws/geocoder/v1/?location=%s&key=%s&get_poi=0", "39.984154,116.307490", key);
        String url = String.format("https://apis.map.qq.com/ws/distance/v1/matrix/?mode=driving&from=38.88353,115.49715&to=38.88753,115.49715;38.88753,115.49015&key=IF2BZ-QU7E3-ZHI33-Y62T5-HP6IS-FNBIT");
        System.out.println("url = " + url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String resultBody = forEntity.getBody();
        System.out.println(resultBody);
        // 解析返回值
        JSONObject jsonObject = JSONObject.parseObject(resultBody);
        Integer status = jsonObject.getInteger("status");
        System.out.println("status = " + status);
        if (0 == status) {
            // JSONArray jsonArray = jsonObject.getJSONObject("result").getJSONObject("rows").getJSONArray("elements");
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
    
        } else {
        
        }
        System.out.println(resultList);
    }

}
