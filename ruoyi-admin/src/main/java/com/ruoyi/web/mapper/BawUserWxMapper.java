package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawUserWx;

import java.util.List;


/**
 * 微信用户Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-12
 */
public interface BawUserWxMapper
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
     * 删除微信用户
     *
     * @param id 微信用户主键
     * @return 结果
     */
    public int deleteBawUserWxById(Integer id);

    /**
     * 批量删除微信用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawUserWxByIds(String[] ids);
    
    /**
     * 通过openId查询用户信息
     * @param openId
     * @return
     */
    public BawUserWx queryByOpenId(String openId);
    
    /**
     * 通过token查询用户信息
     * @param token
     * @return
     */
    public BawUserWx selectByToken(String token);
    
    /**
     * 通过用户id修改 微信名，微信头像url，手机号码
     * @param bawUserWx 用户信息
     * @return
     */
    public int saveUserInfo(BawUserWx bawUserWx);
}
