package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawTestDriveCommentWx;

/**
 * @author sunyun
 * @date 2022年03月09日15:07
 */
public interface BawTestDriveCommentWxMapper {

    /**
     * 新增评论
     * @param bawTestDriveCommentWx 评论实体
     * @return
     */
    public int insertBawTestDriveCommentWx(BawTestDriveCommentWx bawTestDriveCommentWx);

    /**
     * 删除
     * @param id 评论主键
     * @return 结果
     */
    public int deleteBawTestDriveCommentWxsById(Integer id);


    BawTestDriveCommentWx selectId(Integer driveId);


}
