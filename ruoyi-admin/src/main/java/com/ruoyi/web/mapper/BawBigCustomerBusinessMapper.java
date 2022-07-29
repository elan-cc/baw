package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawBigCustomerBusiness;

/**
 * 大客户业务Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-10
 */
public interface BawBigCustomerBusinessMapper 
{
    /**
     * 查询大客户业务
     * 
     * @param id 大客户业务主键
     * @return 大客户业务
     */
    public BawBigCustomerBusiness selectBawBigCustomerBusinessById(Integer id);

    /**
     * 查询大客户业务列表
     * 
     * @param bawBigCustomerBusiness 大客户业务
     * @return 大客户业务集合
     */
    public List<BawBigCustomerBusiness> selectBawBigCustomerBusinessList(BawBigCustomerBusiness bawBigCustomerBusiness);

    /**
     * 新增大客户业务
     * 
     * @param bawBigCustomerBusiness 大客户业务
     * @return 结果
     */
    public int insertBawBigCustomerBusiness(BawBigCustomerBusiness bawBigCustomerBusiness);

    /**
     * 修改大客户业务
     * 
     * @param bawBigCustomerBusiness 大客户业务
     * @return 结果
     */
    public int updateBawBigCustomerBusiness(BawBigCustomerBusiness bawBigCustomerBusiness);

    /**
     * 删除大客户业务
     * 
     * @param id 大客户业务主键
     * @return 结果
     */
    public int deleteBawBigCustomerBusinessById(Integer id);

    /**
     * 批量删除大客户业务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawBigCustomerBusinessByIds(String[] ids);
}
