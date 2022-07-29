package com.ruoyi.web.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawActivityWx;
import com.ruoyi.web.domain.BawInformationOfficialWx;
import io.swagger.models.auth.In;

/**
 * 官方资讯/精彩推荐Service接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface IBawInformationOfficialWxService
{
    /**
     * 查询官方资讯/精彩推荐
     *
     * @param id 官方资讯/精彩推荐主键
     * @return 官方资讯
     */
    public BawInformationOfficialWx selectBawInformationOfficialWxById(Integer id);

    /**
     * 查询官方资讯列表
     *
     * @param bawInformationOfficialWx 官方资讯
     * @return 官方资讯集合
     */
    public List<BawInformationOfficialWx> selectBawInformationOfficialWxList(BawInformationOfficialWx bawInformationOfficialWx);

    /**
     * 新增官方资讯
     *
     * @param bawInformationOfficialWx 官方资讯
     * @return 结果
     */
    public int insertBawInformationOfficialWx(BawInformationOfficialWx bawInformationOfficialWx);

    /**
     * 修改官方资讯
     *
     * @param bawInformationOfficialWx 官方资讯
     * @return 结果
     */
    public int updateBawInformationOfficialWx(BawInformationOfficialWx bawInformationOfficialWx);

    /**
     * 批量删除官方资讯
     *
     * @param ids 需要删除的官方资讯主键集合
     * @return 结果
     */
    public int deleteBawInformationOfficialWxByIds(String ids);

    /**
     * 删除官方资讯信息
     *
     * @param id 官方资讯主键
     * @return 结果
     */
    public int deleteBawInformationOfficialWxById(Integer id);

    /**
     * 通过咨询id查询咨询详情
     * @param infoOfficalId 咨询id
     * @param userId 用户id
     * @return 咨询详情
     */
    Map<String, Object> getBawInformationOfficialWxById(Integer infoOfficalId, Integer userId);

    /**
     * 查询咨询列表
     * @param userId 用户id
     * @param focus 是否为焦点
     * @param type 类型（0:官方资讯，1:精彩推荐）
     * @return
     */
     List<BawInformationOfficialWx>  getInfoOfficialList(Integer userId, Integer focus, Integer type);

    /**
     * 咨询点赞
     * @param infoOfficalId
     * @param userId
     * @return
     */
    int infoOfficalIdList(Integer infoOfficalId, Integer userId);
    
    /**
     * 咨询分享
     * @param id 咨询id
     * @return
     */
    public AjaxResult share(Integer id);
}
