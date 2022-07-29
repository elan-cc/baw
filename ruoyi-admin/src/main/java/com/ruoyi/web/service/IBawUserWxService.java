package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawUserWx;

import java.util.List;


/**
 * 微信用户Service接口
 *
 * @author ruoyi
 * @date 2022-03-12
 */
public interface IBawUserWxService
{
    /**
     * 查询微信用户
     *
     * @param id 微信用户主键
     * @return 微信用户
     */
    public BawUserWx selectBawUserWxById(Integer id);

    /**
     * 查询微信用户列表
     *
     * @param bawUserWx 微信用户
     * @return 微信用户集合
     */
    public List<BawUserWx> selectBawUserWxList(BawUserWx bawUserWx);

    /**
     * 新增微信用户
     *
     * @param bawUserWx 微信用户
     * @return 结果
     */
    public int insertBawUserWx(BawUserWx bawUserWx);

    /**
     * 修改微信用户
     *
     * @param bawUserWx 微信用户
     * @return 结果
     */
    public int updateBawUserWx(BawUserWx bawUserWx);

    /**
     * 批量删除微信用户
     *
     * @param ids 需要删除的微信用户主键集合
     * @return 结果
     */
    public int deleteBawUserWxByIds(String ids);

    /**
     * 删除微信用户信息
     *
     * @param id 微信用户主键
     * @return 结果
     */
    public int deleteBawUserWxById(Integer id);
    
    /**
     * 微信小程序用户登录
     * @param code
     * @return
     */
    public AjaxResult loginByWeixin(String code);
    
    /**
     * 通过token查询用户信息
     * @param token token
     * @return
     */
    public BawUserWx selectByToken(String token);
    
    /**
     * 通过用户id修改 微信名，微信头像url，手机号码
     * @param bawUserWx 微信用户信息
     * @return
     */
    public int saveUserInfo(BawUserWx bawUserWx);
    
    /**
     * 微信小程序用户手机号获取
     * @param code 动态令牌，用于获取手机号
     * @param userId 用户id
     * @return
     */
    public AjaxResult authPhone(String code, Integer userId);
}
