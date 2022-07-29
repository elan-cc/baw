package com.ruoyi.web.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.web.domain.BawCitys;
import org.springframework.ui.ModelMap;

/**
 * 经销商城市Service接口
 *
 * @author ruoyi
 * @date 2021-12-15
 */
public interface IBawCitysService
{
    /**
     * 查询经销商城市
     *
     * @param id 经销商城市主键
     * @return 经销商城市
     */
    public BawCitys selectBawCitysById(Integer id);

    /**
     * 查询经销商城市列表
     *
     * @param bawCitys 经销商城市
     * @return 经销商城市集合
     */
    public List<BawCitys> selectBawCitysList(BawCitys bawCitys);

    /**
     * 查询经销商省份列表For API
     *
     * @return 经销商省份集合
     */
    public List<ModelMap> selectProvinceForApi(Integer isDelete, Integer isDisable);

    /**
     * 查询经销商城市列表For API
     *
     * @return 经销商城市集合
     */
    public List<ModelMap> selectCityForApi(Integer isDelete, Integer isDisable, String province);

    /**
     * 新增经销商城市
     *
     * @param bawCitys 经销商城市
     * @return 结果
     */
    public int insertBawCitys(BawCitys bawCitys);

    /**
     * 修改经销商城市
     *
     * @param bawCitys 经销商城市
     * @return 结果
     */
    public int updateBawCitys(BawCitys bawCitys);

    /**
     * 批量删除经销商城市
     *
     * @param ids 需要删除的经销商城市主键集合
     * @return 结果
     */
    public int deleteBawCitysByIds(String ids);

    /**
     * 删除经销商城市信息
     *
     * @param id 经销商城市主键
     * @return 结果
     */
    public int deleteBawCitysById(Integer id);
    
    /**
     * 查询城市列表根据首字母排序
     * @return
     */
    public List<ModelMap> selectCitySort(String city);
}
