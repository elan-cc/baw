package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawHelpCenterWx;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 帮助中心Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-22
 */
public interface BawHelpCenterWxMapper
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
     * 删除帮助中心
     *
     * @param id 帮助中心主键
     * @return 结果
     */
    public int deleteBawHelpCenterWxById(Integer id);

    /**
     * 批量删除帮助中心
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawHelpCenterWxByIds(String[] ids);
    
    public List<ModelMap> queryHelpCenterList(@Param("questionType") Integer questionType, @Param("isHot") Integer isHot);
}
