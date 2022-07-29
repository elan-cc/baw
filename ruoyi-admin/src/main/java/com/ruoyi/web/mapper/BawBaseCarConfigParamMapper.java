package com.ruoyi.web.mapper;



import com.ruoyi.web.domain.BawBaseCarConfigParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 车型配置参数Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-11
 */
public interface BawBaseCarConfigParamMapper {
    /**
     * 查询车型配置参数
     *
     * @param id 车型配置参数主键
     * @return 车型配置参数
     */
    public BawBaseCarConfigParam selectBawBaseCarConfigParamById(Integer id);

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
    public List<BawBaseCarConfigParam> selecList(BawBaseCarConfigParam bawBaseCarConfigParam);    /**
     * 查询车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 车型配置参数
     */
    public List<BawBaseCarConfigParam> selecListOreder(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 新增车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 结果
     */
    public int insertBawBaseCarConfigParam(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 修改车型配置参数
     *
     * @param bawBaseCarConfigParam 车型配置参数
     * @return 结果
     */
    public int updateBawBaseCarConfigParam(BawBaseCarConfigParam bawBaseCarConfigParam);
    public int updateBawBaseCarConfig(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 删除车型配置参数
     *
     * @param id 车型配置参数主键
     * @return 结果
     */
    public int deleteBawBaseCarConfigParamById(Integer id);

    /**
     * 批量删除车型配置参数
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawBaseCarConfigParamByIds(String[] ids);

    /**
     * 批量删除车型配置参数
     *
     * @param carConfigCode 车型编码
     * @param paramName 配置名称
     * @return 结果
     */
    public int deleteBawBaseCarConfigParamByname(@Param("carConfigCode") String carConfigCode, @Param("paramName") String paramName);

    /**
     * 通过车系id 查询相关车系所有配置
     *
     * @param ids 车系id集合，传空则为查全部
     * @return
     */
    public List<BawBaseCarConfigParam> queryConfigurationById(@Param("ids") String[] ids);

    /**
     * 通过车系编码查询配置
     *
     * @param carSeriesCode 车系编码
     * @return
     */
    public List<BawBaseCarConfigParam> queryBycarSeriesCode(@Param("carSeriesCode") String carSeriesCode);

    /**
     * 查询所有车型
     *
     * @param bawBaseCarConfigParam
     * @return
     */
    List<String> selectCode(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 查询车辆信息数量
     *
     * @param bawBaseCarConfigParam
     * @return
     */
    int selectBawBaseCarConfigParamCount(BawBaseCarConfigParam bawBaseCarConfigParam);

    /**
     * 与 车辆配置分组 表联查
     *
     * @param carSeriesCode
     * @return
     */
    public List<ModelMap> selectLeftJoinConfigGroup(String carSeriesCode);

    /**
     * 通过车系编号分组查询车辆配置编码
     *
     * @param carSeriesCode 车系编号
     * @return
     */
    public List<ModelMap> selectCarConfigCode(String carSeriesCode);

    /**
     * 查询车辆信息数量
     *
     * @param bawBaseCarConfigParam
     * @return
     */
    int selectBawBaseCarConfigParamCounts(BawBaseCarConfigParam bawBaseCarConfigParam);

    int selectCounts(BawBaseCarConfigParam bawBaseCarConfigParam);
    /**
     * 通过车型编码删除
     * @param carConfigCode 车型编码
     * @return
     */
    int deleteBawBaseCarConfigParamByCarConfigCode(@Param("carConfigCode") String carConfigCode);

    void updateBawBaseCarConfigParamExcil(BawBaseCarConfigParam bawBaseCarConfigParam);

    BawBaseCarConfigParam selectValue(BawBaseCarConfigParam bawBaseCarConfigParam);

    List<BawBaseCarConfigParam> selectEdit(BawBaseCarConfigParam bawBaseCarConfigParam);
    int deleteBawBaseCarList(BawBaseCarConfigParam bawBaseCarConfigParam);
}
