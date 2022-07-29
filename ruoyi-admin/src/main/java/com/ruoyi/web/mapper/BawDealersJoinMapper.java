package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawDealersJoin;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 经销商加盟Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-15
 */
public interface BawDealersJoinMapper 
{
    /**
     * 查询经销商加盟
     * 
     * @param id 经销商加盟主键
     * @return 经销商加盟
     */
    public BawDealersJoin selectBawDealersJoinById(Integer id);

    /**
     * 查询经销商加盟列表
     * 
     * @param bawDealersJoin 经销商加盟
     * @return 经销商加盟集合
     */
    public List<BawDealersJoin> selectBawDealersJoinList(BawDealersJoin bawDealersJoin);

    /**
     * 查询经销商加盟列表For API
     *
     * @return 经销商加盟集合
     */
    public List<ModelMap> selectBawDealersJoinListForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable, @Param("province") String province, @Param("city") String city, @Param("keywords") String keywords);

    /**
     * 新增经销商加盟
     * 
     * @param bawDealersJoin 经销商加盟
     * @return 结果
     */
    public int insertBawDealersJoin(BawDealersJoin bawDealersJoin);

    /**
     * 修改经销商加盟
     * 
     * @param bawDealersJoin 经销商加盟
     * @return 结果
     */
    public int updateBawDealersJoin(BawDealersJoin bawDealersJoin);

    /**
     * 删除经销商加盟
     * 
     * @param id 经销商加盟主键
     * @return 结果
     */
    public int deleteBawDealersJoinById(Integer id);

    /**
     * 批量删除经销商加盟
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawDealersJoinByIds(String[] ids);
}
