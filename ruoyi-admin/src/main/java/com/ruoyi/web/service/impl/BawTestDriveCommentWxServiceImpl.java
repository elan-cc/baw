package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawTestDriveCommentWx;
import com.ruoyi.web.domain.BawTestDriveWx;
import com.ruoyi.web.mapper.BawTestDriveCommentWxMapper;
import com.ruoyi.web.mapper.BawTestDriveWxMapper;
import com.ruoyi.web.service.BawTestDriveCommentWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BawTestDriveCommentWxServiceImpl implements BawTestDriveCommentWxService {
    @Autowired
    private BawTestDriveCommentWxMapper bawTestDriveCommentWxMapper;
    /** 预约试驾 */
    @Autowired
    private BawTestDriveWxMapper bawTestDriveWxMapper;

    @Override
    public int insertBawTestDriveCommentWx(BawTestDriveCommentWx bawTestDriveReviewWx) {
        return bawTestDriveCommentWxMapper.insertBawTestDriveCommentWx(bawTestDriveReviewWx);
    }

    @Override
    public int deleteBawTestDriveCommentWxsById(Integer id) {
        return bawTestDriveCommentWxMapper.deleteBawTestDriveCommentWxsById(id);
    }

    /**
     * 预约试驾评价
     * @param bawTestDriveCommentWx 预约试驾评价信息
     * @return
     */
    @Override
    public AjaxResult testDriveEvaluation(BawTestDriveCommentWx bawTestDriveCommentWx) {
        BawTestDriveWx bawTestDriveWx = bawTestDriveWxMapper.selectBawTestDriveWxById(bawTestDriveCommentWx.getBawTestDriveWxId());
        if (StringUtils.isNull(bawTestDriveWx)){
            return AjaxResult.error("相关预约试驾记录不存在！");
        }
        if (bawTestDriveWx.getStatus() != 1){
            return AjaxResult.error("当前预约记录不是待评价状态，不可评价！");
        }
        if (bawTestDriveCommentWx.getServiceAttitude() < 0 || bawTestDriveCommentWx.getServiceAttitude() > 5) {
            return AjaxResult.error("服务态度参数不正确！");
        }
        if (bawTestDriveCommentWx.getCleanDesktop() < 0 || bawTestDriveCommentWx.getCleanDesktop() > 5) {
            return AjaxResult.error("桌面整洁参数不正确！");
        }
        if (bawTestDriveCommentWx.getQualityOfPersonnel() < 0 || bawTestDriveCommentWx.getQualityOfPersonnel() > 5) {
            return AjaxResult.error("人员素质参数不正确！");
        }
        int i = bawTestDriveCommentWxMapper.insertBawTestDriveCommentWx(bawTestDriveCommentWx);
        if (i == 1){
            // 设置预约试驾记录状态为 已完成（2）
            bawTestDriveWx.setStatus(2);
            bawTestDriveWxMapper.updateBawTestDriveWx(bawTestDriveWx);
            return AjaxResult.success("评价成功！");
        } else {
            return AjaxResult.error("评价失败！");
        }
    }

    @Override
    public BawTestDriveCommentWx selectId(Integer id) {
        return bawTestDriveCommentWxMapper.selectId(id);
    }
}
