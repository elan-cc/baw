package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawBaseDealershop;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * 门店信息Service接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface IBawBaseDealershopService
{
    /**
     * 查询门店信息
     *
     * @param id 门店信息主键
     * @return 门店信息
     */
    public BawBaseDealershop selectBawBaseDealershopById(Integer id);

    /**
     * 查询门店信息列表
     *
     * @param bawBaseDealershop 门店信息
     * @return 门店信息集合
     */
    public List<BawBaseDealershop> selectBawBaseDealershopList(BawBaseDealershop bawBaseDealershop);
    /**
     * 官网查询门店信息列表
     *
     * @param
     * @return 门店信息集合
     */
    public List<BawBaseDealershop> selectBawBaseDealershopListForBAW(BawBaseDealershop bawBaseDealershop);

    /**
     * 小程序查询门店信息列表，并通过坐标点计算距离
     * @param bawBaseDealershop 门店信息
     * @param location 经纬度 格式：lat<纬度>,lng<经度>，例：39.984154,116.307490
     * @return 门店信息集合
     */
    public Map<String, Object> selectBawBaseDealershopListForBAW(BawBaseDealershop bawBaseDealershop, String location);

    /**
     * 新增门店信息
     *
     * @param bawBaseDealershop 门店信息
     * @return 结果
     */
    public int insertBawBaseDealershop(BawBaseDealershop bawBaseDealershop);

    /**
     * 修改门店信息
     *
     * @param bawBaseDealershop 门店信息
     * @return 结果
     */
    public int updateBawBaseDealershop(BawBaseDealershop bawBaseDealershop);

    /**
     * 批量删除门店信息
     *
     * @param ids 需要删除的门店信息主键集合
     * @return 结果
     */
    public int deleteBawBaseDealershopByIds(Integer[] ids);

    /**
     * 删除门店信息信息
     *
     * @param id 门店信息主键
     * @return 结果
     */
    public int deleteBawBaseDealershopById(Integer id);
    /**
     * 查询门店信息
     *
     * @param dlrCode 门店信息code
     * @return 门店信息
     */
    public List<BawBaseDealershop>  selectBawBaseDealershopByDlrCode(String dlrCode);


    String importBawBaseDealershop(List<BawBaseDealershop> bawBaseDealershopList, String loginName);
}
