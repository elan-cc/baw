package com.ruoyi.web.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawOwnerCertificationWx;
import com.ruoyi.web.mapper.BawOwnerCertificationWxMapper;
import com.ruoyi.web.service.IBawOwnerCertificationWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 车主认证Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-13
 */
@Service
public class BawOwnerCertificationWxServiceImpl implements IBawOwnerCertificationWxService
{
    @Autowired
    private BawOwnerCertificationWxMapper bawOwnerCertificationWxMapper;

    /**
     * 查询车主认证
     *
     * @param id 车主认证主键
     * @return 车主认证
     */
    @Override
    public BawOwnerCertificationWx selectBawOwnerCertificationWxById(Integer id)
    {
        return bawOwnerCertificationWxMapper.selectBawOwnerCertificationWxById(id);
    }

    /**
     * 查询车主认证列表
     *
     * @param bawOwnerCertificationWx 车主认证
     * @return 车主认证
     */
    @Override
    public List<BawOwnerCertificationWx> selectBawOwnerCertificationWxList(BawOwnerCertificationWx bawOwnerCertificationWx)
    {
        return bawOwnerCertificationWxMapper.selectBawOwnerCertificationWxList(bawOwnerCertificationWx);
    }

    /**
     * 新增车主认证
     *
     * @param bawOwnerCertificationWx 车主认证
     * @return 结果
     */
    @Override
    public int insertBawOwnerCertificationWx(BawOwnerCertificationWx bawOwnerCertificationWx)
    {
        return bawOwnerCertificationWxMapper.insertBawOwnerCertificationWx(bawOwnerCertificationWx);
    }

    /**
     * 修改车主认证
     *
     * @param bawOwnerCertificationWx 车主认证
     * @return 结果
     */
    @Override
    public int updateBawOwnerCertificationWx(BawOwnerCertificationWx bawOwnerCertificationWx)
    {
        return bawOwnerCertificationWxMapper.updateBawOwnerCertificationWx(bawOwnerCertificationWx);
    }

    /**
     * 批量删除车主认证
     *
     * @param ids 需要删除的车主认证主键
     * @return 结果
     */
    @Override
    public int deleteBawOwnerCertificationWxByIds(String ids)
    {
        return bawOwnerCertificationWxMapper.deleteBawOwnerCertificationWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车主认证信息
     *
     * @param id 车主认证主键
     * @return 结果
     */
    @Override
    public int deleteBawOwnerCertificationWxById(Integer id)
    {
        return bawOwnerCertificationWxMapper.deleteBawOwnerCertificationWxById(id);
    }

    /**
     * 车主认证CRM
     * @param chassis 底盘号
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult certificationCRM(String chassis,Integer userId){
        int count = bawOwnerCertificationWxMapper.selectCount(userId);
        if (count != 0){
            return AjaxResult.error("该车已认证！");
        }else {
            BawOwnerCertificationWx bawOwnerCertificationWx = new BawOwnerCertificationWx();
            bawOwnerCertificationWx.setChassis(chassis);
            bawOwnerCertificationWx.setUserId(userId);
            bawOwnerCertificationWx.setCreatyTime(new Date());
            int i = bawOwnerCertificationWxMapper.insertBawOwnerCertificationWx(bawOwnerCertificationWx);
            return AjaxResult.success(i);
        }
    }

    /**
     * 车主认证
     * @param userId 用户id
     * @return
     */
    @Override
    public int selectCount(Integer userId) {
        int count = bawOwnerCertificationWxMapper.selectCount(userId);
        if (count == 0){
            return 1;
        }else {
            return 0;
        }
    }
}
