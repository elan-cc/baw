package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawProductDetailWx;
import com.ruoyi.web.mapper.BawProductDetailWxMapper;
import com.ruoyi.web.service.IBawProductDetailWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 产品手册详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-27
 */
@Service
public class BawProductDetailWxServiceImpl implements IBawProductDetailWxService
{
    @Autowired
    private BawProductDetailWxMapper bawProductDetailWxMapper;

    /**
     * 查询产品手册详情
     *
     * @param id 产品手册详情主键
     * @return 产品手册详情
     */
    @Override
    public BawProductDetailWx selectBawProductDetailWxById(Integer id)
    {
        return bawProductDetailWxMapper.selectBawProductDetailWxById(id);
    }

    /**
     * 查询产品手册详情列表
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 产品手册详情
     */
    @Override
    public List<BawProductDetailWx> selectBawProductDetailWxList(BawProductDetailWx bawProductDetailWx)
    {
        return bawProductDetailWxMapper.selectBawProductDetailWxList(bawProductDetailWx);
    }

    /**
     * 新增产品手册详情
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 结果
     */
    @Override
    public int insertBawProductDetailWx(BawProductDetailWx bawProductDetailWx)
    {

        return bawProductDetailWxMapper.insertBawProductDetailWx(bawProductDetailWx);
    }

    /**
     * 修改产品手册详情
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 结果
     */
    @Override
    public int updateBawProductDetailWx(BawProductDetailWx bawProductDetailWx)
    {
        bawProductDetailWx.setUpdateTime(DateUtils.getNowDate());
        return bawProductDetailWxMapper.updateBawProductDetailWx(bawProductDetailWx);
    }

    /**
     * 批量删除产品手册详情
     *
     * @param ids 需要删除的产品手册详情主键
     * @return 结果
     */
    @Override
    public int deleteBawProductDetailWxByIds(String ids)
    {
        return bawProductDetailWxMapper.deleteBawProductDetailWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品手册详情信息
     *
     * @param id 产品手册详情主键
     * @return 结果
     */
    @Override
    public int deleteBawProductDetailWxById(Integer id)
    {
        return bawProductDetailWxMapper.deleteBawProductDetailWxById(id);
    }

    /**
     *
     */
    @Override
    public List<ModelMap> selectId(Integer manualId){
        List<ModelMap> modelMaps = bawProductDetailWxMapper.selectId(manualId);
        return modelMaps;
    }

    @Override
    public List<ModelMap> selectDetailWxById(Integer id) {
        return bawProductDetailWxMapper.selectDetailWxById(id);
    }
}
