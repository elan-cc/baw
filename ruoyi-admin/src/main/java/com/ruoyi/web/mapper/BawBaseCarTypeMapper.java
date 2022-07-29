package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawBaseCarType;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 车型信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface BawBaseCarTypeMapper
{
    /**
     * 查询车型信息
     *
     * @param id 车型信息主键
     * @return 车型信息
     */
    public BawBaseCarType selectBawBaseCarTypeById(Integer id);

    /**
     * 查询车型信息列表
     *
     * @param bawBaseCarType 车型信息
     * @return 车型信息集合
     */
    public List<BawBaseCarType> selectBawBaseCarTypeList(BawBaseCarType bawBaseCarType);

    /**
     * 新增车型信息
     *
     * @param bawBaseCarType 车型信息
     * @return 结果
     */
    public int insertBawBaseCarType(BawBaseCarType bawBaseCarType);

    /**
     * 修改车型信息
     *
     * @param bawBaseCarType 车型信息
     * @return 结果
     */
    public int updateBawBaseCarType(BawBaseCarType bawBaseCarType);

    /**
     * 删除车型信息
     *
     * @param id 车型信息主键
     * @return 结果
     */
    public int deleteBawBaseCarTypeById(Integer id);

    /**
     * 批量删除车型信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawBaseCarTypeByIds(Integer[] ids);


    public List<ModelMap> selectType(String code);

    public List<ModelMap> selectCode(String code);
    /**
     * 小程序车型配置信息
     *
     * @param code 车型信息主键
     * @return 结果
     */
    public List<ModelMap> selectCodeApplet(String code);

    public String select(String code);
    /**
     * 根据一级车系（carSeriesCode）车型配置获取车型配置信息
     * @param serviceCode
     * @return
     */
    public List<ModelMap> selectBawBaseCarTypeConfigurationAppletByCarSeriesCode(String serviceCode);
}
