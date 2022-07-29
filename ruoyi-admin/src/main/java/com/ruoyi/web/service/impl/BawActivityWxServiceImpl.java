package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawActivityLikeWx;
import com.ruoyi.web.domain.BawActivityRegistrationWx;
import com.ruoyi.web.domain.BawActivityWx;
import com.ruoyi.web.mapper.BawActivityLikeWxMapper;
import com.ruoyi.web.mapper.BawActivityRegistrationWxMapper;
import com.ruoyi.web.mapper.BawActivityWxMapper;
import com.ruoyi.web.mapper.BawCitysMapper;
import com.ruoyi.web.service.IBawActivityWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 活动Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class BawActivityWxServiceImpl implements IBawActivityWxService
{
    @Autowired
    private BawActivityWxMapper bawActivityWxMapper;
    /**活动点赞记录*/
    @Autowired
    private BawActivityLikeWxMapper bawActivityLikeWxMapper;
    /**活动报名*/
    @Autowired
    private BawActivityRegistrationWxMapper bawActivityRegistrationWxMapper;
    @Autowired
    private BawCitysMapper bawCitysMapper;

    /**
     * 查询活动
     *
     * @param id 活动主键
     * @return 活动
     */
    @Override
    public BawActivityWx selectBawActivityWxById(Integer id)
    {
        BawActivityWx bawActivityWx =bawActivityWxMapper.selectBawActivityWxById(id);
        return bawActivityWx;
    }

    /**
     * 查询活动列表
     *
     * @param bawActivityWx 活动
     * @return 活动
     */
    @Override
    public List<BawActivityWx> selectBawActivityWxList(BawActivityWx bawActivityWx)
    {
        bawActivityWx.setIsDeleted(0);
        return bawActivityWxMapper.selectBawActivityWxList(bawActivityWx);
    }

    /**
     * 新增活动
     *
     * @param bawActivityWx 活动
     * @return 结果
     */
    @Override
    public int insertBawActivityWx(BawActivityWx bawActivityWx)
    {
        Date time = new Date();
        long timestamp = time.getTime();
        long long1 = bawActivityWx.getStartTime().getTime();
        long long2 = bawActivityWx.getEndTime().getTime();
        if (long1 < timestamp || long1 > long2) {

        }
        if (long1 > long2) {
            //10：开始时间早于结束时间
            return 10;
        }
        if (StringUtils.isBlank(bawActivityWx.getThumbnail())){
            return 20;
        }
        /*if (StringUtils.isBlank(bawActivityWx.getActivityDescribe())){
            return 30;
        }*/
        bawActivityWx.setIsDeleted(0);
        bawActivityWx.setCreateTime(DateUtils.getNowDate());
        String province = bawCitysMapper.selectBawProvinceByCode(bawActivityWx.getProvinceCode());
        bawActivityWx.setProvinceName(province);
        String city = bawCitysMapper.selectBawCityByCode(bawActivityWx.getCityCode());
        bawActivityWx.setCityName(city);
        if (bawActivityWx.getProvinceCode().equals("0")){
            bawActivityWx.setProvinceName("全国");
            bawActivityWx.setCityCode("01");
            bawActivityWx.setCityName("-");
        }
        return bawActivityWxMapper.insertBawActivityWx(bawActivityWx);
    }

    /**
     * 修改活动
     *
     * @param bawActivityWx 活动
     * @return 结果
     */
    @Override
    public int updateBawActivityWx(BawActivityWx bawActivityWx) {
        Date time = new Date();
        long timestamp = time.getTime();
        long long1 = bawActivityWx.getStartTime().getTime();
        long long2 = bawActivityWx.getEndTime().getTime();
        if (long1 < timestamp || long1 > long2) {

        }
        if (long1 > long2) {
            //10：开始时间早于结束时间
            return 10;
        }
        if (StringUtils.isBlank(bawActivityWx.getThumbnail())){
            return 20;
        }
        /*if (StringUtils.isBlank(bawActivityWx.getActivityDescribe())){
            return 30;
        }*/
        bawActivityWx.setUpdateTime(DateUtils.getNowDate());
        String province = bawCitysMapper.selectBawProvinceByCode(bawActivityWx.getProvinceCode());
        bawActivityWx.setProvinceName(province);
        String city = bawCitysMapper.selectBawCityByCode(bawActivityWx.getCityCode());
        bawActivityWx.setCityName(city);
        if (bawActivityWx.getProvinceCode().equals("0")){
            bawActivityWx.setProvinceName("全国");
            bawActivityWx.setCityCode("01");
            bawActivityWx.setCityName("-");
        }
        return bawActivityWxMapper.updateBawActivityWx(bawActivityWx);
    }

    /**
     * 批量删除活动
     *
     * @param ids 需要删除的活动主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityWxByIds(String ids)
    {
        return bawActivityWxMapper.deleteBawActivityWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动信息
     *
     * @param id 活动主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityWxById(Integer id) {
        BawActivityRegistrationWx bawActivityRegistrationWx = new BawActivityRegistrationWx();
        bawActivityRegistrationWx.setActivityId(id);
        List<BawActivityRegistrationWx> bawActivityRegistrationWxList = bawActivityRegistrationWxMapper.selectBawActivityRegistrationWxList(bawActivityRegistrationWx);
        if (bawActivityRegistrationWxList != null && bawActivityRegistrationWxList.size() > 0) {
            return 10;
        }
        return bawActivityWxMapper.deleteBawActivityWxById(id);
    }

    /**
     * 通过城市code查询活动列表（根据创建时间排序）
     * @param cityCode 城市code
     * @param userId 用户id
     * @return
     */
    @Override
    public List<BawActivityWx> getActivityList(String cityCode, Integer userId,Integer activityType) {
        List<BawActivityWx> activityList = bawActivityWxMapper.getActivityList(cityCode,activityType);
        if (null != userId){
            for (BawActivityWx bawActivityWx : activityList) {
                int i = bawActivityLikeWxMapper.selectCountByActivityIdAndUserId(bawActivityWx.getId(), userId);
                if (i == 0){
                    bawActivityWx.setIsLike(false);
                } else {
                    bawActivityWx.setIsLike(true);
                }
            }
        }
        return activityList;
    }

    /**
     * 通过活动id查询活动详情，参与人数（报名人头像，报名总数）
     * @param activityId 活动id
     * @param count 要查询的报名人头像数量
     * @param userId 用户id
     * @return 活动详情
     */
    @Override
    public Map<String, Object> getActivityById(Integer activityId, Integer count, Integer userId) {
        Map<String, Object> resultMap = new HashMap<>();
        // 查询活动详情
        BawActivityWx bawActivityWx = bawActivityWxMapper.selectById(activityId);
        if (StringUtils.isNull(bawActivityWx)){
            return null;
        }
        if (0 == bawActivityWx.getIsAble()){
            return null;
        }
        // 增加浏览量
        bawActivityWxMapper.addViewCount(activityId);
        // 判断用户是否点赞该活动
        int i = 0;
        if (null != userId){
            i = bawActivityLikeWxMapper.selectCountByActivityIdAndUserId(activityId, userId);
        }
        if (i == 0){
            bawActivityWx.setIsLike(false);
        } else {
            bawActivityWx.setIsLike(true);
        }
        resultMap.put("result", bawActivityWx);
        // 查询count个报名人头像，和报名总数
        List<String> avatars = new ArrayList<>();
        List<BawActivityRegistrationWx> bawActivityRegistrationWxes = bawActivityRegistrationWxMapper.selectListByActivityIdAndCount(activityId, count);
        for (BawActivityRegistrationWx bawActivityRegistrationWx : bawActivityRegistrationWxes) {
            avatars.add(bawActivityRegistrationWx.getAvatar());
        }
        resultMap.put("avatars",avatars);
        int f = bawActivityRegistrationWxMapper.selectCountByActivityId(activityId);
        resultMap.put("participantsCount",f);
        return resultMap;
    }

    /**
     * 活动点赞/取消点赞
     * @param id 活动id
     * @param userId 用户id
     * @return
     */
    @Override
    public int activityList(Integer id, Integer userId) {
        // 查询该用户是否已点赞
        if (null != userId){
            BawActivityLikeWx activityLikeWx = new BawActivityLikeWx();
            activityLikeWx.setActivityId(id);
            activityLikeWx.setUserId(userId);
            List<BawActivityLikeWx> likeWxes = bawActivityLikeWxMapper.selectBawActivityLikeWxList(activityLikeWx);
            if (null != likeWxes && likeWxes.size() > 0) {
                // 取消点赞
                bawActivityWxMapper.cancelActivityList(id);
                // 删除点赞记录
                int i = bawActivityLikeWxMapper.deleteBawActivityLikeWxById(likeWxes.get(0).getId());
                return i;
            }
        }
        int i = bawActivityWxMapper.activityList(id);
        if (null != userId){
            // 新增活动点赞记录
            BawActivityLikeWx likeWx = new BawActivityLikeWx();
            likeWx.setActivityId(id);
            likeWx.setUserId(userId);
            likeWx.setLikesTime(new Date());
            bawActivityLikeWxMapper.insertBawActivityLikeWx(likeWx);
        }
        return i;
    }

    /**
     * 我的活动
     * @param activityState 活动状态(1:进行中,2:已结束)
     * @param userId 用户id
     * @return
     */
    @Override
    public List<BawActivityWx> myActivities(Integer activityState, Integer userId) {
        if (StringUtils.isNull(activityState)){
            return null;
        }
        if (1 != activityState && 2 != activityState){
            return null;
        }
        return bawActivityWxMapper.myActivity(activityState, userId);
    }
}
