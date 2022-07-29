package com.ruoyi.web.service;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawBaseCarConfigParam;
import com.ruoyi.web.domain.BawBaseCarConfigParamDeserialization;

import java.util.List;

/**
 * 车型配置参数Service接口
 *
 * @author ruoyi
 * @date 2022-03-11
 */
public interface IBawBaseCarConfigParamService
{
    /**
     * 查询车型配置参数
     *
     * @param carConfigCode 车型编码
     * @return
     */
    public BawBaseCarConfigParamDeserialization selectBawBaseCarConfigParamById(String carConfigCode);

    /**
     * 查询车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 车型配置参数
     */
    public List<BawBaseCarConfigParam> selectBawBaseCarConfigParamList(BawBaseCarConfigParam bawBaseCarConfigParam);
    /**
     * 查询车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 车型配置参数
     */
    public List<BawBaseCarConfigParam> selectBawBaseCarConfigParamPageList(BawBaseCarConfigParam bawBaseCarConfigParam);
    /**
     * 查询车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 车型配置参数
     */
    public List<BawBaseCarConfigParam> selectBawBaseCarConfigList(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 新增车型配置参数
     *
     * @param bawBaseCarConfig 车型配置参数
     * @return 结果
     */
    public int insertBawBaseCarConfigParam(BawBaseCarConfigParamDeserialization baseCarConfigParamDeserialization);
    /**
     * 新增车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 结果
     */
    public int insertBawBaseCarConfigParams(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 修改车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 结果
     */
    public int updateBawBaseCarConfigParam(BawBaseCarConfigParam bawBaseCarConfigParam);
    public int updateBawBaseCarConfig(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 批量删除车型配置参数
     *
     * @param ids 需要删除的车型配置参数主键集合
     * @return 结果
     */
    public int deleteBawBaseCarConfigParamByIds(String ids);
    /**
     * 批量删除车型配置参数
     *
     * @param carConfigCode 车型编码
     * @param paramName 配置名称
     * @return 结果
     */
    public int deleteBawBaseCarConfigParamByname(String carConfigCode, String paramName);

    /**
     * 删除车型配置参数信息
     *
     * @param id 车型配置参数主键
     * @return 结果
     */
    public int deleteBawBaseCarConfigParamById(Integer id);

    /**
     * 通过车系id查询相关车系所有配置
     *
     * @param ids 车系id集合，传空则为查全部
     * @return
     */
    AjaxResult queryConfigurationById(String ids);

    /**
     * 通过车系编码查询配置
     * @param carSeriesCode 车系编码
     * @return
     */
    AjaxResult queryBycarSeriesCode(String carSeriesCode);

    /**
     * 通过车系编码查询数量
     * @param bawBaseCarConfigParam
     * @return
     */
    int selectBawBaseCarConfigParamCount(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 导入
     * @param bawBaseCarConfigParams
     * @param loginName
     * @param loginName
     * @return
     */
    String importBawBaseCarConfigParam(List<BawBaseCarConfigParam> bawBaseCarConfigParams, String loginName);

    /**
     * 根据车系编号查询配置
     * @param carSeriesCode 车系编号
     * @return
     */
    public AjaxResult queryConfig(String carSeriesCode);

    /**
     * 通过id查询设备配置信息
     * @param id
     * @return
     */
    public BawBaseCarConfigParam selectById(Integer id);

    /**
     * 通过车型编码删除
     * @param carConfigCode 车型编码
     * @return
     */
    int deleteBawBaseCarConfigParamByCarConfigCode(String carConfigCode);
}
