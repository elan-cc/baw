package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawProductDetailWx;
import org.springframework.ui.ModelMap;

import javax.management.modelmbean.ModelMBean;
import java.util.List;

/**
 * 产品手册详情Service接口
 *
 * @author ruoyi
 * @date 2022-05-27
 */
public interface IBawProductDetailWxService
{
    /**
     * 查询产品手册详情
     *
     * @param id 产品手册详情主键
     * @return 产品手册详情
     */
    public BawProductDetailWx selectBawProductDetailWxById(Integer id);

    /**
     * 查询产品手册详情列表
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 产品手册详情集合
     */
    public List<BawProductDetailWx> selectBawProductDetailWxList(BawProductDetailWx bawProductDetailWx);

    /**
     * 新增产品手册详情
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 结果
     */
    public int insertBawProductDetailWx(BawProductDetailWx bawProductDetailWx);

    /**
     * 修改产品手册详情
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 结果
     */
    public int updateBawProductDetailWx(BawProductDetailWx bawProductDetailWx);

    /**
     * 批量删除产品手册详情
     *
     * @param ids 需要删除的产品手册详情主键集合
     * @return 结果
     */
    public int deleteBawProductDetailWxByIds(String ids);

    /**
     * 删除产品手册详情信息
     *
     * @param id 产品手册详情主键
     * @return 结果
     */
    public int deleteBawProductDetailWxById(Integer id);

    public List<ModelMap> selectId(Integer manualId);

    public  List<ModelMap> selectDetailWxById(Integer id);



}
