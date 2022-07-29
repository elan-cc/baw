package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawTechnicalSupportWx;

/**
 * 技术支持Service接口
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public interface IBawTechnicalSupportWxService 
{
    /**
     * 查询技术支持
     * 
     * @param id 技术支持主键
     * @return 技术支持
     */
    public BawTechnicalSupportWx selectBawTechnicalSupportWxById(Integer id);

    /**
     * 查询技术支持列表
     * 
     * @param bawTechnicalSupportWx 技术支持
     * @return 技术支持集合
     */
    public List<BawTechnicalSupportWx> selectBawTechnicalSupportWxList(BawTechnicalSupportWx bawTechnicalSupportWx);

    /**
     * 新增技术支持
     * 
     * @param bawTechnicalSupportWx 技术支持
     * @return 结果
     */
    public int insertBawTechnicalSupportWx(BawTechnicalSupportWx bawTechnicalSupportWx);

    /**
     * 修改技术支持
     * 
     * @param bawTechnicalSupportWx 技术支持
     * @return 结果
     */
    public int updateBawTechnicalSupportWx(BawTechnicalSupportWx bawTechnicalSupportWx);

    /**
     * 批量删除技术支持
     * 
     * @param ids 需要删除的技术支持主键集合
     * @return 结果
     */
    public int deleteBawTechnicalSupportWxByIds(String ids);

    /**
     * 删除技术支持信息
     * 
     * @param id 技术支持主键
     * @return 结果
     */
    public int deleteBawTechnicalSupportWxById(Integer id);
}
