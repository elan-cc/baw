package com.ruoyi.web.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.web.domain.BawDealersJoin;
import org.springframework.ui.ModelMap;

/**
 * 经销商加盟Service接口
 *
 * @author ruoyi
 * @date 2021-12-15
 */
public interface IBawDealersJoinService
{
    /**
     * 查询经销商加盟
     *
     * @param id 经销商加盟主键
     * @return 经销商加盟
     */
    public BawDealersJoin selectBawDealersJoinById(Integer id);

    /**
     * 查询经销商加盟列表
     *
     * @param bawDealersJoin 经销商加盟
     * @return 经销商加盟集合
     */
    public List<BawDealersJoin> selectBawDealersJoinList(BawDealersJoin bawDealersJoin);

    /**
     * 查询经销商加盟列表For API
     *
     * @return 经销商加盟集合
     */
    public List<ModelMap> selectBawDealersJoinListForApi(Integer isDelete, Integer isDisable, String province, String city, String keywords);

    /**
     * 新增经销商加盟
     *
     * @param bawDealersJoin 经销商加盟
     * @return 结果
     */
    public int insertBawDealersJoin(BawDealersJoin bawDealersJoin);

    /**
     * 修改经销商加盟
     *
     * @param bawDealersJoin 经销商加盟
     * @return 结果
     */
    public int updateBawDealersJoin(BawDealersJoin bawDealersJoin);

    /**
     * 批量删除经销商加盟
     *
     * @param ids 需要删除的经销商加盟主键集合
     * @return 结果
     */
    public int deleteBawDealersJoinByIds(String ids);

    /**
     * 删除经销商加盟信息
     *
     * @param id 经销商加盟主键
     * @return 结果
     */
    public int deleteBawDealersJoinById(Integer id);
    /**
     * 调取腾讯api，根据传入的地址查询坐标点
     * @param address 地址（注：地址中请包含城市名称，否则会影响解析效果）
     */
    public Map<String,Double> findCoordinatesByAddress(String address);
    
    /**
     * 逆地址解析（根据坐标查询地址）
     * @param location 经纬度 格式：lat<纬度>,lng<经度>
     * @return
     */
    public Map<String, Object> findAddressByCoordinates(String location);
}
