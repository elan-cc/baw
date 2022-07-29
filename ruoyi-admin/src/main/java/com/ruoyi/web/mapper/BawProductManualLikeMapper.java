package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawProductManualLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品手册点赞Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-11
 */
public interface BawProductManualLikeMapper
{
    /**
     * 查询产品手册点赞
     *
     * @param id 产品手册点赞主键
     * @return 产品手册点赞
     */
    public BawProductManualLike selectBawProductManualLikeById(Integer id);

    /**
     * 查询产品手册点赞列表
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 产品手册点赞集合
     */
    public List<BawProductManualLike> selectBawProductManualLikeList(BawProductManualLike bawProductManualLike);

    /**
     * 新增产品手册点赞
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 结果
     */
    public int insertBawProductManualLike(BawProductManualLike bawProductManualLike);

    /**
     * 修改产品手册点赞
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 结果
     */
    public int updateBawProductManualLike(BawProductManualLike bawProductManualLike);

    /**
     * 删除产品手册点赞
     *
     * @param id 产品手册点赞主键
     * @return 结果
     */
    public int deleteBawProductManualLikeById(Integer id);

    /**
     * 批量删除产品手册点赞
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawProductManualLikeByIds(String[] ids);
    
    /**
     * 通过产品手册id和用户id查询产品手册点赞记录
     * @param manuaIdl 产品手册id
     * @param userId 用户id
     * @return
     */
    BawProductManualLike selectByIdAndUserId(@Param("manuaIdl") Integer manuaIdl, @Param("userId") Integer userId);
}
