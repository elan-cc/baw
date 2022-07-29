package com.ruoyi.web.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawShippingAddressMapper;
import com.ruoyi.web.domain.BawShippingAddress;
import com.ruoyi.web.service.IBawShippingAddressService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收货地址Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-18
 */
@Service
public class BawShippingAddressServiceImpl implements IBawShippingAddressService
{
    @Autowired
    private BawShippingAddressMapper bawShippingAddressMapper;

    /**
     * 查询收货地址
     *
     * @param id 收货地址主键
     * @return 收货地址
     */
    @Override
    public BawShippingAddress selectBawShippingAddressById(Integer id)
    {
        return bawShippingAddressMapper.selectBawShippingAddressById(id);
    }

    /**
     * 查询收货地址列表
     *
     * @param bawShippingAddress 收货地址
     * @return 收货地址
     */
    @Override
    public List<BawShippingAddress> selectBawShippingAddressList(BawShippingAddress bawShippingAddress)
    {
        return bawShippingAddressMapper.selectBawShippingAddressList(bawShippingAddress);
    }

    /**
     * 新增收货地址
     *
     * @param bawShippingAddress 收货地址
     * @return 结果
     */
    @Override
    public int insertBawShippingAddress(BawShippingAddress bawShippingAddress)
    {
        bawShippingAddress.setCreateTime(DateUtils.getNowDate());
        return bawShippingAddressMapper.insertBawShippingAddress(bawShippingAddress);
    }

    /**
     * 修改收货地址
     *
     * @param bawShippingAddress 收货地址
     * @return 结果
     */
    @Override
    public int updateBawShippingAddress(BawShippingAddress bawShippingAddress)
    {
        bawShippingAddress.setUpdateTime(DateUtils.getNowDate());
        return bawShippingAddressMapper.updateBawShippingAddress(bawShippingAddress);
    }

    /**
     * 批量删除收货地址
     *
     * @param ids 需要删除的收货地址主键
     * @return 结果
     */
    @Override
    public int deleteBawShippingAddressByIds(String ids)
    {
        return bawShippingAddressMapper.deleteBawShippingAddressByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收货地址信息
     *
     * @param id 收货地址主键
     * @return 结果
     */
    @Override
    public int deleteBawShippingAddressById(Integer id)
    {
        return bawShippingAddressMapper.deleteBawShippingAddressById(id);
    }
    
    @Override
    public AjaxResult saveAddress(BawShippingAddress bawShippingAddress) {
        if (StringUtils.isNull(bawShippingAddress.getId())){
            // 新增
            BawShippingAddress address = new BawShippingAddress();
            address.setUserId(bawShippingAddress.getUserId());
            List<BawShippingAddress> addresses = bawShippingAddressMapper.selectBawShippingAddressList(address);
            if (addresses.size() == 0) {
                // 当前用户还没有收货地址，第一条收货地址设置为默认
                bawShippingAddress.setIsDefault(1);
            }else if (1 == bawShippingAddress.getIsDefault()){
                // 该收货信息设置为默认（1），将其他默认修改为非默认（0）
                bawShippingAddressMapper.toNotDefault(bawShippingAddress.getUserId());
            }
            bawShippingAddress.setCreateTime(new Date());
            int i = bawShippingAddressMapper.insertBawShippingAddress(bawShippingAddress);
            if (0 == i){
                return AjaxResult.error("新增收货地址成功！");
            } else {
                return AjaxResult.success("新增收货地址成功！");
            }
        } else {
            // 修改
            BawShippingAddress address = bawShippingAddressMapper.selectBawShippingAddressById(bawShippingAddress.getId());
            if (StringUtils.isNull(address)){
                return AjaxResult.error("修改收货地址失败,未找到相关收货地址！");
            }
            bawShippingAddress.setCreateTime(address.getCreateTime());
            bawShippingAddress.setUpdateTime(new Date());
            bawShippingAddress.setIsDefault(address.getIsDefault());
            /*if (1 == bawShippingAddress.getIsDefault()){
                // 该收货信息设置为默认（1），将其他默认修改为非默认（0）
                bawShippingAddressMapper.toNotDefault(bawShippingAddress.getUserId());
            } else {
                // 该收货信息设置为非默认（0），查询该用户下是否有其他状态为默认的地址，如果没有则返回，必须有一个默认地址
            }*/
            
        }
        int i = bawShippingAddressMapper.updateBawShippingAddress(bawShippingAddress);
        if (0 == i){
            return AjaxResult.error("修改收货地址成功！");
        } else {
            return AjaxResult.success("修改收货地址成功！");
        }
    }
    
    /**
     * 收货地址切换默认选择
     * @param id 收货地址id
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult addressSwitchDefault(Integer id, Integer userId) {
        BawShippingAddress bawShippingAddress = bawShippingAddressMapper.selectBawShippingAddressById(id);
        if (StringUtils.isNull(bawShippingAddress)){
            return AjaxResult.error("设置失败，未找到相关收货地址信息！");
        }
        if (1 == bawShippingAddress.getIsDefault()){
            // 如果当前收货地址信息为默认状态，则直接返回，不用修改
            return AjaxResult.success("设置成功！");
        } else {
            bawShippingAddressMapper.toNotDefault(bawShippingAddress.getUserId());
            bawShippingAddress.setIsDefault(1);
            bawShippingAddressMapper.updateBawShippingAddress(bawShippingAddress);
            return AjaxResult.success("设置成功！");
        }
    }
}

