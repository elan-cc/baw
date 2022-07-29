package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawBaseDealershop;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 门店信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface BawBaseDealershopMapper
{
    /**
     * 查询门店信息
     *
     * @param id 门店信息主键
     * @return 门店信息
     */
    public BawBaseDealershop selectBawBaseDealershopById(Integer id);

    /**
     * 查询门店信息列表
     *
     * @param bawBaseDealershop 门店信息
     * @return 门店信息集合
     */
    public List<BawBaseDealershop> selectBawBaseDealershopList(BawBaseDealershop bawBaseDealershop);
    /**
     * BAW查询门店信息列表
     *
     * @param
     * @return 门店信息集合
     */
    public List<BawBaseDealershop> selectBawBaseDealershopListForBAW(BawBaseDealershop bawBaseDealershop);

    /**
     * 新增门店信息
     *
     * @param bawBaseDealershop 门店信息
     * @return 结果
     */
    public int insertBawBaseDealershop(BawBaseDealershop bawBaseDealershop);

    /**
     * 修改门店信息
     *
     * @param bawBaseDealershop 门店信息
     * @return 结果
     */
    public int updateBawBaseDealershop(BawBaseDealershop bawBaseDealershop);

    /**
     * 删除门店信息
     *
     * @param id 门店信息主键
     * @return 结果
     */
    public int deleteBawBaseDealershopById(Integer id);

    /**
     * 批量删除门店信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawBaseDealershopByIds(Integer[] ids);

    public List<BawBaseDealershop>  selectBawBaseDealershopByDlrCode(String dlrCode);

    /**
     * 查询门店信息数量
     * @param bawBaseDealershop 门店信息
     * @return
     */
    public int selectBawBaseDealershopListForBAWCount(BawBaseDealershop bawBaseDealershop);

    void updateBawBaseDealershopExcil(BawBaseDealershop bawBaseDealershop);

    /**
     * 根据表名查询经销商名字
     * @param tableName 表名
     * @return
     */
    public List<ModelMap> selectBawBaseDealershopByName(@Param("tableName") String tableName);

    public List<ModelMap> selectBawBaseDealershopByCity(String cityc);
    public List<ModelMap> selectBawBaseDealershop();
}
