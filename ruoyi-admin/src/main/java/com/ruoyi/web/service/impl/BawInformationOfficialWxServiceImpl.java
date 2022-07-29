package com.ruoyi.web.service.impl;

import java.util.*;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawInformationOfficialLikesWx;
import com.ruoyi.web.mapper.BawInformationOfficialLikesWxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawInformationOfficialWxMapper;
import com.ruoyi.web.domain.BawInformationOfficialWx;
import com.ruoyi.web.service.IBawInformationOfficialWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 官方资讯/精彩推荐Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class BawInformationOfficialWxServiceImpl implements IBawInformationOfficialWxService
{
    @Autowired
    private BawInformationOfficialWxMapper bawInformationOfficialWxMapper;
    @Autowired
    private BawInformationOfficialLikesWxMapper bawInformationOfficialLikesWxMapper;
    /**
     * 查询官方资讯/精彩推荐
     *
     * @param id 官方资讯/精彩推荐主键
     * @return 官方资讯/精彩推荐
     */
    @Override
    public BawInformationOfficialWx selectBawInformationOfficialWxById(Integer id)
    {
        return bawInformationOfficialWxMapper.selectBawInformationOfficialWxById(id);
    }

    /**
     * 查询官方资讯/精彩推荐列表
     *
     * @param bawInformationOfficialWx 官方资讯/精彩推荐
     * @return 官方资讯/精彩推荐
     */
    @Override
    public List<BawInformationOfficialWx> selectBawInformationOfficialWxList(BawInformationOfficialWx bawInformationOfficialWx)
    {
        bawInformationOfficialWx.setInfoIsDelete(0);
        return bawInformationOfficialWxMapper.selectBawInformationOfficialWxList(bawInformationOfficialWx);
    }

    /**
     * 新增官方资讯/精彩推荐
     *
     * @param bawInformationOfficialWx 官方资讯/精彩推荐
     * @return 结果
     */
    @Override
    public int insertBawInformationOfficialWx(BawInformationOfficialWx bawInformationOfficialWx)
    {
        int num = toFocus(bawInformationOfficialWx);
        if (num == 1) {
            bawInformationOfficialWx.setInfoLikesNumber(0);
            bawInformationOfficialWx.setCreateTime(DateUtils.getNowDate());
            bawInformationOfficialWx.setInfoIsDelete(0);
            bawInformationOfficialWx.setInfoViewsCount(0);
            bawInformationOfficialWx.setShareCount(0);
            return bawInformationOfficialWxMapper.insertBawInformationOfficialWx(bawInformationOfficialWx);
        } else {
            return num;
        }

    }

    /**
     * 修改官方资讯/精彩推荐
     *
     * @param bawInformationOfficialWx 官方资讯/精彩推荐
     * @return 结果
     */
    @Override
    public int updateBawInformationOfficialWx(BawInformationOfficialWx bawInformationOfficialWx) {

        int num = toFocus(bawInformationOfficialWx);
        if (num == 1) {
            bawInformationOfficialWx.setUpdateTime(DateUtils.getNowDate());
            return bawInformationOfficialWxMapper.updateBawInformationOfficialWx(bawInformationOfficialWx);
        } else {
            return num;
        }
    }

    /**
     * 批量删除官方资讯/精彩推荐
     *
     * @param ids 需要删除的官方资讯/精彩推荐主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialWxByIds(String ids)
    {
        return bawInformationOfficialWxMapper.deleteBawInformationOfficialWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除官方资讯/精彩推荐信息
     *
     * @param id 官方资讯/精彩推荐主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialWxById(Integer id)
    {
        return bawInformationOfficialWxMapper.deleteBawInformationOfficialWxById(id);
    }

    /**
     * 通过咨询id查询咨询详情
     * @param infoOfficalId 咨询id
     * @param userId 用户id
     * @return 咨询详情
     */
    @Override
    public Map<String, Object> getBawInformationOfficialWxById(Integer infoOfficalId, Integer userId) {
        Map<String, Object> resultMap = new HashMap<>();
        // 查询活动详情
        BawInformationOfficialWx bawInformationOfficialWx = bawInformationOfficialWxMapper.selectById(infoOfficalId);
        if (StringUtils.isNull(bawInformationOfficialWx)){
            return null;
        }
        if (2 == bawInformationOfficialWx.getInfoArticleEnable()){
            return null;
        }
        // 增加浏览量
        bawInformationOfficialWxMapper.addViewCount(infoOfficalId);
        // 判断用户是否点赞该活动
        int i = 0;
        if (null != userId){
            i = bawInformationOfficialLikesWxMapper.selectCountByInfoOfficalIdAndUserId(infoOfficalId, userId);
        }
        if (i == 0){
            bawInformationOfficialWx.setIsLike(false);
        } else {
            bawInformationOfficialWx.setIsLike(true);
        }
        resultMap.put("result", bawInformationOfficialWx);
        return resultMap;
    }
    
    /**
     * 查询咨询列表
     * @param userId 用户id
     * @param focus 是否为焦点
     * @param type 类型（0:官方资讯，1:精彩推荐）
     * @return
     */
    @Override
    public List<BawInformationOfficialWx> getInfoOfficialList(Integer userId, Integer focus, Integer type) {
        List<BawInformationOfficialWx> bawInformationOfficialWxList = null;
        if (focus == 1) {
            BawInformationOfficialWx bawInformationOfficialWx = new BawInformationOfficialWx();
            bawInformationOfficialWx.setInfoArticleEnable(1);
            bawInformationOfficialWx.setInfoIsDelete(0);
            bawInformationOfficialWx.setType(type);
            bawInformationOfficialWxList = bawInformationOfficialWxMapper.selectBawInformationOfficialWxList(bawInformationOfficialWx);
        } else if (focus == 2) {
            bawInformationOfficialWxList = bawInformationOfficialWxMapper.getInfoOfficialList(focus,type);
        }
        if (null != userId) {
            for (BawInformationOfficialWx bawInformationOfficialWx : bawInformationOfficialWxList) {
                int i = bawInformationOfficialLikesWxMapper.selectCountByInfoOfficalIdAndUserId(bawInformationOfficialWx.getId(), userId);
                if (i == 0) {
                    bawInformationOfficialWx.setIsLike(false);
                } else {
                    bawInformationOfficialWx.setIsLike(true);
                }
            }
        }
        return bawInformationOfficialWxList;
    }

    @Override
    public int infoOfficalIdList(Integer infoOfficalId, Integer userId) {
        // 查询该用户是否已点赞
        if (null != userId){
            BawInformationOfficialLikesWx bawInformationOfficialLikesWx = new BawInformationOfficialLikesWx();
            bawInformationOfficialLikesWx.setInformationId(infoOfficalId);
            bawInformationOfficialLikesWx.setUserId(userId);
            List<BawInformationOfficialLikesWx> likeWxes = bawInformationOfficialLikesWxMapper.selectBawInformationOfficialLikesWxList(bawInformationOfficialLikesWx);
            if (null != likeWxes && likeWxes.size() > 0) {
                // 取消点赞
                bawInformationOfficialWxMapper.cancelInformationOfficialList(infoOfficalId);
                // 删除点赞记录
                int i = bawInformationOfficialLikesWxMapper.deleteBawInformationOfficialLikesWxById(likeWxes.get(0).getId());
                return i;
            }
        }
        int i = bawInformationOfficialWxMapper.informationOfficialList(infoOfficalId);
        if (null != userId){
            // 新增活动点赞记录
            BawInformationOfficialLikesWx likeWx = new BawInformationOfficialLikesWx();
            likeWx.setInformationId(infoOfficalId);
            likeWx.setUserId(userId);
            likeWx.setLikesTime(new Date());
            bawInformationOfficialLikesWxMapper.insertBawInformationOfficialLikesWx(likeWx);

        }
        return i;
    }
    
    /**
     * 咨询分享记录
     * @param id 咨询id
     * @return
     */
    @Override
    public AjaxResult share(Integer id) {
        bawInformationOfficialWxMapper.share(id);
        return AjaxResult.success("成功！");
    }
    
    
    public int toFocus(BawInformationOfficialWx bawInformationOfficialWx) {
        int focusCount = bawInformationOfficialWxMapper.selectBawInformationOfficialWxFocusCount();
        if (focusCount >= 5 && bawInformationOfficialWx.getInfoFocus() == 2) {
            if (bawInformationOfficialWx.getId() != null) {
                BawInformationOfficialWx b = bawInformationOfficialWxMapper.selectBawInformationOfficialWxById(bawInformationOfficialWx.getId());
                if (b.getInfoFocus() == 2) {
                   return 1;
                }
            }
            return 2;
        } else {
            return 1;
        }
    }
}
