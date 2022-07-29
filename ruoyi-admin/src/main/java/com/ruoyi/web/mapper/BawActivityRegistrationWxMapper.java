package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawActivityRegistrationWx;
import org.apache.ibatis.annotations.Param;

/**
 * 活动报名Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface BawActivityRegistrationWxMapper
{
    /**
     * 查询活动报名
     *
     * @param id 活动报名主键
     * @return 活动报名
     */
    public BawActivityRegistrationWx selectBawActivityRegistrationWxById(Integer id);

    /**
     * 查询活动报名列表
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 活动报名集合
     */
    public List<BawActivityRegistrationWx> selectBawActivityRegistrationWxList(BawActivityRegistrationWx bawActivityRegistrationWx);

    /**
     * 新增活动报名
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 结果
     */
    public int insertBawActivityRegistrationWx(BawActivityRegistrationWx bawActivityRegistrationWx);

    /**
     * 修改活动报名
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 结果
     */
    public int updateBawActivityRegistrationWx(BawActivityRegistrationWx bawActivityRegistrationWx);

    /**
     * 删除活动报名
     *
     * @param id 活动报名主键
     * @return 结果
     */
    public int deleteBawActivityRegistrationWxById(Integer id);

    /**
     * 批量删除活动报名
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawActivityRegistrationWxByIds(String[] ids);
    
    /**
     * 通过活动id和数量查询参与人头像
     * @param activityId 活动id
     * @param count 数量
     * @return
     */
    public List<BawActivityRegistrationWx> selectListByActivityIdAndCount(@Param("activityId") Integer activityId, @Param("count") Integer count);
    
    /**
     * 通过活动id查询报名人数
     * @param activityId 活动id
     * @return
     */
    public int selectCountByActivityId(Integer activityId);
    
    /**
     * 通过活动id和手机号码查询活动报名实体
     * @param activityId 活动id
     * @param phone 手机号
     * @return
     */
    public BawActivityRegistrationWx selectByPhone(@Param("activityId") Integer activityId,@Param("phone") String phone);
}
