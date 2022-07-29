package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawTestDriveCommentWx;

/**
 * @author sunyun
 * @date 2022年03月09日15:12
 */
public interface BawTestDriveCommentWxService {
    /**
     * 新增评论
     * @param bawTestDriveCommentWx
     * @return
     */

    public int insertBawTestDriveCommentWx(BawTestDriveCommentWx bawTestDriveCommentWx);

    /**
     * 删除评论
     *
     * @return 结果
     */
    public int deleteBawTestDriveCommentWxsById(Integer id);

    /**
     * 预约试驾评价
     * @param bawTestDriveCommentWx 预约试驾评价信息
     * @return
     */
    public AjaxResult testDriveEvaluation(BawTestDriveCommentWx bawTestDriveCommentWx);

    public BawTestDriveCommentWx selectId(Integer id);

}
