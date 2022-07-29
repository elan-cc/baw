package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawBigCustomerBusinessMapper;
import com.ruoyi.web.domain.BawBigCustomerBusiness;
import com.ruoyi.web.service.IBawBigCustomerBusinessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 大客户业务Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-10
 */
@Service
public class BawBigCustomerBusinessServiceImpl implements IBawBigCustomerBusinessService 
{
    @Autowired
    private BawBigCustomerBusinessMapper bawBigCustomerBusinessMapper;

    /**
     * 查询大客户业务
     * 
     * @param id 大客户业务主键
     * @return 大客户业务
     */
    @Override
    public BawBigCustomerBusiness selectBawBigCustomerBusinessById(Integer id)
    {
        return bawBigCustomerBusinessMapper.selectBawBigCustomerBusinessById(id);
    }

    /**
     * 查询大客户业务列表
     * 
     * @param bawBigCustomerBusiness 大客户业务
     * @return 大客户业务
     */
    @Override
    public List<BawBigCustomerBusiness> selectBawBigCustomerBusinessList(BawBigCustomerBusiness bawBigCustomerBusiness)
    {
        return bawBigCustomerBusinessMapper.selectBawBigCustomerBusinessList(bawBigCustomerBusiness);
    }

    /**
     * 新增大客户业务
     * 
     * @param bawBigCustomerBusiness 大客户业务
     * @return 结果
     */
    @Override
    public int insertBawBigCustomerBusiness(BawBigCustomerBusiness bawBigCustomerBusiness)
    {
        return bawBigCustomerBusinessMapper.insertBawBigCustomerBusiness(bawBigCustomerBusiness);
    }

    /**
     * 修改大客户业务
     * 
     * @param bawBigCustomerBusiness 大客户业务
     * @return 结果
     */
    @Override
    public int updateBawBigCustomerBusiness(BawBigCustomerBusiness bawBigCustomerBusiness)
    {
        return bawBigCustomerBusinessMapper.updateBawBigCustomerBusiness(bawBigCustomerBusiness);
    }

    /**
     * 批量删除大客户业务
     * 
     * @param ids 需要删除的大客户业务主键
     * @return 结果
     */
    @Override
    public int deleteBawBigCustomerBusinessByIds(String ids)
    {
        return bawBigCustomerBusinessMapper.deleteBawBigCustomerBusinessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除大客户业务信息
     * 
     * @param id 大客户业务主键
     * @return 结果
     */
    @Override
    public int deleteBawBigCustomerBusinessById(Integer id)
    {
        return bawBigCustomerBusinessMapper.deleteBawBigCustomerBusinessById(id);
    }
}
