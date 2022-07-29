package com.ruoyi.web.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawShippingAddress;

/**
 * 收货地址Service接口
 *
 * @author ruoyi
 * @date 2022-04-18
 */
public interface IBawShippingAddressService
{
    /**
     * 查询收货地址
     *
     * @param id 收货地址主键
     * @return 收货地址
     */
    public BawShippingAddress selectBawShippingAddressById(Integer id);

    /**
     * 查询收货地址列表
     *
     * @param bawShippingAddress 收货地址
     * @return 收货地址集合
     */
    public List<BawShippingAddress> selectBawShippingAddressList(BawShippingAddress bawShippingAddress);

    /**
     * 新增收货地址
     *
     * @param bawShippingAddress 收货地址
     * @return 结果
     */
    public int insertBawShippingAddress(BawShippingAddress bawShippingAddress);

    /**
     * 修改收货地址
     *
     * @param bawShippingAddress 收货地址
     * @return 结果
     */
    public int updateBawShippingAddress(BawShippingAddress bawShippingAddress);

    /**
     * 批量删除收货地址
     *
     * @param ids 需要删除的收货地址主键集合
     * @return 结果
     */
    public int deleteBawShippingAddressByIds(String ids);

    /**
     * 删除收货地址信息
     *
     * @param id 收货地址主键
     * @return 结果
     */
    public int deleteBawShippingAddressById(Integer id);
    
    /**
     * 新增/修改 收货地址 （主键id为空则新增；不为空则是修改）
     * @param bawShippingAddress 收货地址信息
     * @return
     */
    public AjaxResult saveAddress(BawShippingAddress bawShippingAddress);
    
    /**
     * 收货地址切换默认选择
     * @param id 收货地址id
     * @param userId 用户id
     * @return
     */
    public AjaxResult addressSwitchDefault(Integer id, Integer userId);
}
