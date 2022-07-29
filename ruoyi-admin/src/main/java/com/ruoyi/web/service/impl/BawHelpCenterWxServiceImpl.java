package com.ruoyi.web.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawHelpCenterWxMapper;
import com.ruoyi.web.domain.BawHelpCenterWx;
import com.ruoyi.web.service.IBawHelpCenterWxService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 帮助中心Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-22
 */
@Service
public class BawHelpCenterWxServiceImpl implements IBawHelpCenterWxService
{
    @Autowired
    private BawHelpCenterWxMapper bawHelpCenterWxMapper;

    /**
     * 查询帮助中心
     *
     * @param id 帮助中心主键
     * @return 帮助中心
     */
    @Override
    public BawHelpCenterWx selectBawHelpCenterWxById(Integer id)
    {
        return bawHelpCenterWxMapper.selectBawHelpCenterWxById(id);
    }

    /**
     * 查询帮助中心列表
     *
     * @param bawHelpCenterWx 帮助中心
     * @return 帮助中心
     */
    @Override
    public List<BawHelpCenterWx> selectBawHelpCenterWxList(BawHelpCenterWx bawHelpCenterWx)
    {
        return bawHelpCenterWxMapper.selectBawHelpCenterWxList(bawHelpCenterWx);
    }

    /**
     * 新增帮助中心
     *
     * @param bawHelpCenterWx 帮助中心
     * @return 结果
     */
    @Override
    public int insertBawHelpCenterWx(BawHelpCenterWx bawHelpCenterWx) {
        bawHelpCenterWx.setIsHot(1);
        bawHelpCenterWx.setCreateTime(DateUtils.getNowDate());
        return bawHelpCenterWxMapper.insertBawHelpCenterWx(bawHelpCenterWx);
    }

    /**
     * 修改帮助中心
     *
     * @param bawHelpCenterWx 帮助中心
     * @return 结果
     */
    @Override
    public int updateBawHelpCenterWx(BawHelpCenterWx bawHelpCenterWx)
    {
        bawHelpCenterWx.setUpdateTime(DateUtils.getNowDate());
        return bawHelpCenterWxMapper.updateBawHelpCenterWx(bawHelpCenterWx);
    }

    /**
     * 批量删除帮助中心
     *
     * @param ids 需要删除的帮助中心主键
     * @return 结果
     */
    @Override
    public int deleteBawHelpCenterWxByIds(String ids)
    {
        return bawHelpCenterWxMapper.deleteBawHelpCenterWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除帮助中心信息
     *
     * @param id 帮助中心主键
     * @return 结果
     */
    @Override
    public int deleteBawHelpCenterWxById(Integer id)
    {
        return bawHelpCenterWxMapper.deleteBawHelpCenterWxById(id);
    }
    
    @Override
    public List<ModelMap> queryHelpCenterList(Integer type) {
        List<ModelMap> modelMaps;
        switch (type) {
            case 3:
                modelMaps = bawHelpCenterWxMapper.queryHelpCenterList(null, 2);
                break;
            default:
                modelMaps = bawHelpCenterWxMapper.queryHelpCenterList(type, null);
                break;
        }
        return modelMaps;
    }
}
