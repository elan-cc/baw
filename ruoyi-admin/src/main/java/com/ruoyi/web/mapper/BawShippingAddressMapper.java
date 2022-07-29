package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawShippingAddress;

/**
 * 收货地址Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-18
 */
public interface BawShippingAddressMapper
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
     * 删除收货地址
     *
     * @param id 收货地址主键
     * @return 结果
     */
    public int deleteBawShippingAddressById(Integer id);

    /**
     * 批量删除收货地址
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawShippingAddressByIds(String[] ids);
    
    /**
     * 通过用户id，将所有收货信息设置为非默认
     * @param userId
     * @return
     */
    public int toNotDefault(Integer userId);
}
