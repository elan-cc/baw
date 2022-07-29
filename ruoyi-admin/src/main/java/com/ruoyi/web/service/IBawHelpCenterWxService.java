package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawHelpCenterWx;
import org.springframework.ui.ModelMap;

/**
 * 帮助中心Service接口
 *
 * @author ruoyi
 * @date 2022-04-22
 */
public interface IBawHelpCenterWxService
{
    /**
     * 查询帮助中心
     *
     * @param id 帮助中心主键
     * @return 帮助中心
     */
    public BawHelpCenterWx selectBawHelpCenterWxById(Integer id);

    /**
     * 查询帮助中心列表
     *
     * @param bawHelpCenterWx 帮助中心
     * @return 帮助中心集合
     */
    public List<BawHelpCenterWx> selectBawHelpCenterWxList(BawHelpCenterWx bawHelpCenterWx);

    /**
     * 新增帮助中心
     *
     * @param bawHelpCenterWx 帮助中心
     * @return 结果
     */
    public int insertBawHelpCenterWx(BawHelpCenterWx bawHelpCenterWx);

    /**
     * 修改帮助中心
     *
     * @param bawHelpCenterWx 帮助中心
     * @return 结果
     */
    public int updateBawHelpCenterWx(BawHelpCenterWx bawHelpCenterWx);

    /**
     * 批量删除帮助中心
     *
     * @param ids 需要删除的帮助中心主键集合
     * @return 结果
     */
    public int deleteBawHelpCenterWxByIds(String ids);

    /**
     * 删除帮助中心信息
     *
     * @param id 帮助中心主键
     * @return 结果
     */
    public int deleteBawHelpCenterWxById(Integer id);
    
    /**
     * 帮助中心列表查询
     * @param type 问题类型 问题类型（1：账号问题；2：发票问题；3：热门问题）
     * @return
     */
    public List<ModelMap> queryHelpCenterList(Integer type);
}
