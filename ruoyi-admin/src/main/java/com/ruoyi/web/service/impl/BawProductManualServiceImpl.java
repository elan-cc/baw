package com.ruoyi.web.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawProductManual;
import com.ruoyi.web.domain.BawProductManualLike;
import com.ruoyi.web.mapper.BawProductManualLikeMapper;
import com.ruoyi.web.mapper.BawProductManualMapper;
import com.ruoyi.web.service.IBawProductManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 产品手册Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-10
 */
@Service
public class BawProductManualServiceImpl implements IBawProductManualService
{
    @Autowired
    private BawProductManualMapper bawProductManualMapper;
    /**产品手册点赞记录*/
    @Autowired
    private BawProductManualLikeMapper bawProductManualLikeMapper;

    /**
     * 查询产品手册
     *
     * @param id 产品手册主键
     * @return 产品手册
     */
    @Override
    public BawProductManual selectBawProductManualById(Integer id)
    {
        return bawProductManualMapper.selectBawProductManualById(id);
    }

    /**
     * 查询产品手册列表
     *
     * @param bawProductManual 产品手册
     * @return 产品手册
     */
    @Override
    public List<BawProductManual> selectBawProductManualList(BawProductManual bawProductManual)
    {
        return bawProductManualMapper.selectBawProductManualList(bawProductManual);
    }

    /**
     * 新增产品手册
     *
     * @param bawProductManual 产品手册
     * @return 结果
     */
    @Override
    public int insertBawProductManual(BawProductManual bawProductManual)
    {
        bawProductManual.setCreatyTime(new Date());
        bawProductManual.setAnalysisQuantity(0);
        bawProductManual.setBrowseQuantity(0);
        bawProductManual.setLikesQuantity(0);
        return bawProductManualMapper.insertBawProductManual(bawProductManual);
    }

    /**
     * 修改产品手册
     *
     * @param bawProductManual 产品手册
     * @return 结果
     */
    @Override
    public int updateBawProductManual(BawProductManual bawProductManual)
    {
        return bawProductManualMapper.updateBawProductManual(bawProductManual);
    }

    /**
     * 批量删除产品手册
     *
     * @param ids 需要删除的产品手册主键
     * @return 结果
     */
    @Override
    public int deleteBawProductManualByIds(String ids)
    {
        return bawProductManualMapper.deleteBawProductManualByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品手册信息
     *
     * @param id 产品手册主键
     * @return 结果
     */
    @Override
    public int deleteBawProductManualById(Integer id)
    {
        return bawProductManualMapper.deleteBawProductManualById(id);
    }

    /**
     * 通过id查询产品手册详情
     * @param id 产品手册id
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult productManualInfo(Integer id, Integer userId) {
        BawProductManual bawProductManual = bawProductManualMapper.selectBawProductManualById(id);
        bawProductManual.setBrowseQuantity(bawProductManual.getBrowseQuantity()+1);
        bawProductManualMapper.updateBawProductManual(bawProductManual);
        if (StringUtils.isNotNull(bawProductManual)){
            if (StringUtils.isNotNull(userId)){
                BawProductManualLike manualLike = new BawProductManualLike();
                manualLike.setManuaIdl(id);
                manualLike.setUserId(userId);
                List<BawProductManualLike> bawProductManualLikes = bawProductManualLikeMapper.selectBawProductManualLikeList(manualLike);
                if (bawProductManualLikes.size() > 0){
                    bawProductManual.setIsList(true);
                } else {
                    bawProductManual.setIsList(false);
                }
            } else {
                bawProductManual.setIsList(false);
            }
            return AjaxResult.success("查询成功！",bawProductManual);
        }else {
            return AjaxResult.error("查询失败，未找到相关产品手册信息！");
        }

    }

    /**
     * 产品手册分享
     * @param id 产品手册id
     * @return
     */
    @Override
    public AjaxResult share(Integer id) {
        bawProductManualMapper.share(id);
        return AjaxResult.success("成功！");
    }

    /**
     * 产品手册点赞
     * @param id 产品手册id
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult productManualLike(Integer id, Integer userId) {
        BawProductManual bawProductManual = bawProductManualMapper.selectBawProductManualById(id);
        if (StringUtils.isNull(bawProductManual)){
            return AjaxResult.error("点赞失败，未查询到相关产品手册！");
        }
        if (StringUtils.isNotNull(userId)){
            BawProductManualLike bawProductManualLike = bawProductManualLikeMapper.selectByIdAndUserId(id, userId);
            if (StringUtils.isNotNull(bawProductManualLike)){
                // 取消点赞 删除产品手册点赞记录，产品手册点赞数-1
                bawProductManualLikeMapper.deleteBawProductManualLikeById(bawProductManualLike.getId());
                bawProductManualMapper.Unlike(id);
                return AjaxResult.success("取消点赞成功！");
            } else {
                // 点赞 增加产品手册点赞记录，产品手册点赞数+1
                BawProductManualLike manualLike = new BawProductManualLike();
                manualLike.setManuaIdl(id);
                manualLike.setUserId(userId);
                manualLike.setLikesTime(new Date());
                bawProductManualLikeMapper.insertBawProductManualLike(manualLike);
                bawProductManualMapper.like(id);
                return AjaxResult.success("点赞成功！");
            }
        } else {
            // 点赞 产品手册点赞数+1
            bawProductManualMapper.like(id);
            return AjaxResult.success("点赞成功！");
        }
    }

    @Override
    public List<ModelMap> selectId(Integer id) {
        return bawProductManualMapper.selectId(id);
    }


}
