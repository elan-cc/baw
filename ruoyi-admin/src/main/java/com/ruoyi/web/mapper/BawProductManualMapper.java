package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawProductManual;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

import java.beans.Introspector;
import java.util.List;

/**
 * 产品手册Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-10
 */
public interface BawProductManualMapper
{
    /**
     * 查询产品手册
     *
     * @param id 产品手册主键
     * @return 产品手册
     */
    public BawProductManual selectBawProductManualById(Integer id);

    /**
     * 查询产品手册列表
     *
     * @param bawProductManual 产品手册
     * @return 产品手册集合
     */
    public List<BawProductManual> selectBawProductManualList(BawProductManual bawProductManual);

    /**
     * 新增产品手册
     *
     * @param bawProductManual 产品手册
     * @return 结果
     */
    public int insertBawProductManual(BawProductManual bawProductManual);

    /**
     * 修改产品手册
     *
     * @param bawProductManual 产品手册
     * @return 结果
     */
    public int updateBawProductManual(BawProductManual bawProductManual);

    /**
     * 删除产品手册
     *
     * @param id 产品手册主键
     * @return 结果
     */
    public int deleteBawProductManualById(Integer id);

    /**
     * 批量删除产品手册
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawProductManualByIds(String[] ids);

    /**
     * 取消点赞
     * @param manualId 咨询id
     */
    void updateBawProductManualLikes(Integer manualId);

    /**
     * 点赞
     * @param manualId 咨询id
     * @return
     */
    int updateBawProductManualAddLikes(@Param("manualId") Integer manualId);


    /**
     * 产品手册分享
     * @param id 产品手册id
     */
    public void share(Integer id);

    /**
     * 产品手册点赞数-1
     * @param id 产品手册id
     */
    void Unlike(Integer id);

    /**
     * 产品手册点赞数+1
     * @param id 产品手册id
     */
    void like(Integer id);

    List<ModelMap> selectId(Integer id);
}
