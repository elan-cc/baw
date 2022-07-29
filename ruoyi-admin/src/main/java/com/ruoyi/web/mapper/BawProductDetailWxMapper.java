package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawProductDetailWx;
import io.swagger.models.auth.In;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 产品手册详情Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-27
 */
public interface BawProductDetailWxMapper
{
    /**
     * 查询产品手册详情
     *
     * @param id 产品手册详情主键
     * @return 产品手册详情
     */
    public BawProductDetailWx selectBawProductDetailWxById(Integer id);

    /**
     * 查询产品手册详情列表
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 产品手册详情集合
     */
    public List<BawProductDetailWx> selectBawProductDetailWxList(BawProductDetailWx bawProductDetailWx);

    /**
     * 新增产品手册详情
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 结果
     */
    public int insertBawProductDetailWx(BawProductDetailWx bawProductDetailWx);

    /**
     * 修改产品手册详情
     *
     * @param bawProductDetailWx 产品手册详情
     * @return 结果
     */
    public int updateBawProductDetailWx(BawProductDetailWx bawProductDetailWx);

    /**
     * 删除产品手册详情
     *
     * @param id 产品手册详情主键
     * @return 结果
     */
    public int deleteBawProductDetailWxById(Integer id);

    /**
     * 批量删除产品手册详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawProductDetailWxByIds(String[] ids);

    public List<ModelMap> selectId(Integer bawProductDetailWx);
    public List<ModelMap> selectDetailWxById(Integer id);
}
