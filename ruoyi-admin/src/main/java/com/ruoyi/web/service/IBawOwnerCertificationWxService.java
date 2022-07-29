package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawOwnerCertificationWx;
import org.apache.commons.collections4.IterableGet;
import springfox.documentation.spring.web.json.Json;

import java.util.Iterator;
import java.util.List;

/**
 * 车主认证Service接口
 *
 * @author ruoyi
 * @date 2022-06-13
 */
public interface IBawOwnerCertificationWxService
{
    /**
     * 查询车主认证
     *
     * @param id 车主认证主键
     * @return 车主认证
     */
    public BawOwnerCertificationWx selectBawOwnerCertificationWxById(Integer id);

    /**
     * 查询车主认证列表
     *
     * @param bawOwnerCertificationWx 车主认证
     * @return 车主认证集合
     */
    public List<BawOwnerCertificationWx> selectBawOwnerCertificationWxList(BawOwnerCertificationWx bawOwnerCertificationWx);

    /**
     * 新增车主认证
     *
     * @param bawOwnerCertificationWx 车主认证
     * @return 结果
     */
    public int insertBawOwnerCertificationWx(BawOwnerCertificationWx bawOwnerCertificationWx);

    /**
     * 修改车主认证
     *
     * @param bawOwnerCertificationWx 车主认证
     * @return 结果
     */
    public int updateBawOwnerCertificationWx(BawOwnerCertificationWx bawOwnerCertificationWx);

    /**
     * 批量删除车主认证
     *
     * @param ids 需要删除的车主认证主键集合
     * @return 结果
     */
    public int deleteBawOwnerCertificationWxByIds(String ids);

    /**
     * 删除车主认证信息
     *
     * @param id 车主认证主键
     * @return 结果
     */
    public int deleteBawOwnerCertificationWxById(Integer id);

    /**
     * 车主认证CRM
     * @param chassis 底盘号
     * @param userId 用户id
     * @return
     */
    public AjaxResult certificationCRM(String chassis,Integer userId);

    /**
     *车主认证
     * @param userId 用户id
     * @return
     */
    public int selectCount(Integer userId);
}
