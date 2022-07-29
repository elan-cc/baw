package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawCitys;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 经销商城市Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-15
 */
public interface BawCitysMapper
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
    public List<ModelMap> selectProvinceForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable);

    /**
     * 查询经销商城市列表For API
     *
     * @return 经销商城市集合
     */
    public List<ModelMap> selectCityForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable, @Param("province") String province);

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
     * 删除经销商城市
     *
     * @param id 经销商城市主键
     * @return 结果
     */
    public int deleteBawCitysById(Integer id);

    /**
     * 批量删除经销商城市
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawCitysByIds(String[] ids);

    /**
     * 根据code查询城市name
     * @param code
     * @return
     */
    public String selectBawCityByCode(String code);

    /**
     * 根据code查询省name
     * @param code
     * @return
     */
    public String selectBawProvinceByCode(String code);
    
    
    /**
     * 查询经销商城市列表
     *
     * @return 经销商城市集合
     */
    public List<ModelMap> selectCitys(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable, @Param("city") String city);
}
