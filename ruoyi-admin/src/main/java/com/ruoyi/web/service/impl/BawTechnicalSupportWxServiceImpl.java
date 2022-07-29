package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawTechnicalSupportWxMapper;
import com.ruoyi.web.domain.BawTechnicalSupportWx;
import com.ruoyi.web.service.IBawTechnicalSupportWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 技术支持Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
@Service
public class BawTechnicalSupportWxServiceImpl implements IBawTechnicalSupportWxService 
{
    @Autowired
    private BawTechnicalSupportWxMapper bawTechnicalSupportWxMapper;

    /**
     * 查询技术支持
     * 
     * @param id 技术支持主键
     * @return 技术支持
     */
    @Override
    public BawTechnicalSupportWx selectBawTechnicalSupportWxById(Integer id)
    {
        return bawTechnicalSupportWxMapper.selectBawTechnicalSupportWxById(id);
    }

    /**
     * 查询技术支持列表
     * 
     * @param bawTechnicalSupportWx 技术支持
     * @return 技术支持
     */
    @Override
    public List<BawTechnicalSupportWx> selectBawTechnicalSupportWxList(BawTechnicalSupportWx bawTechnicalSupportWx)
    {
        return bawTechnicalSupportWxMapper.selectBawTechnicalSupportWxList(bawTechnicalSupportWx);
    }

    /**
     * 新增技术支持
     * 
     * @param bawTechnicalSupportWx 技术支持
     * @return 结果
     */
    @Override
    public int insertBawTechnicalSupportWx(BawTechnicalSupportWx bawTechnicalSupportWx)
    {
        bawTechnicalSupportWx.setCreateTime(DateUtils.getNowDate());
        return bawTechnicalSupportWxMapper.insertBawTechnicalSupportWx(bawTechnicalSupportWx);
    }

    /**
     * 修改技术支持
     * 
     * @param bawTechnicalSupportWx 技术支持
     * @return 结果
     */
    @Override
    public int updateBawTechnicalSupportWx(BawTechnicalSupportWx bawTechnicalSupportWx)
    {
        bawTechnicalSupportWx.setUpdateTime(DateUtils.getNowDate());
        return bawTechnicalSupportWxMapper.updateBawTechnicalSupportWx(bawTechnicalSupportWx);
    }

    /**
     * 批量删除技术支持
     * 
     * @param ids 需要删除的技术支持主键
     * @return 结果
     */
    @Override
    public int deleteBawTechnicalSupportWxByIds(String ids)
    {
        return bawTechnicalSupportWxMapper.deleteBawTechnicalSupportWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术支持信息
     * 
     * @param id 技术支持主键
     * @return 结果
     */
    @Override
    public int deleteBawTechnicalSupportWxById(Integer id)
    {
        return bawTechnicalSupportWxMapper.deleteBawTechnicalSupportWxById(id);
    }
}
