package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawOrderManagement;

/**
 * 订单管理Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface BawOrderManagementMapper
{
    /**
     * 查询订单管理
     *
     * @param id 订单管理主键
     * @return 订单管理
     */
    public BawOrderManagement selectBawOrderManagementById(Integer id);

    /**
     * 查询订单管理列表
     *
     * @param bawOrderManagement 订单管理
     * @return 订单管理集合
     */
    public List<BawOrderManagement> selectBawOrderManagementList(BawOrderManagement bawOrderManagement);

    /**
     * 新增订单管理
     *
     * @param bawOrderManagement 订单管理
     * @return 结果
     */
    public int insertBawOrderManagement(BawOrderManagement bawOrderManagement);

    /**
     * 修改订单管理
     *
     * @param bawOrderManagement 订单管理
     * @return 结果
     */
    public int updateBawOrderManagement(BawOrderManagement bawOrderManagement);

    /**
     * 删除订单管理
     *
     * @param id 订单管理主键
     * @return 结果
     */
    public int deleteBawOrderManagementById(Integer id);

    /**
     * 批量删除订单管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawOrderManagementByIds(String[] ids);

    /**
     * 通过订单编号查询
     * @param orderNum
     * @return
     */
    public BawOrderManagement selectByOrderNum(String orderNum);

}
