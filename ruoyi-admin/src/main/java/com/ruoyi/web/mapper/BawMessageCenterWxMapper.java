package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawMessageCenterWx;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 消息中心Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-10
 */
public interface BawMessageCenterWxMapper
{
    /**
     * 查询消息中心
     *
     * @param id 消息中心主键
     * @return 消息中心
     */
    public BawMessageCenterWx selectBawMessageCenterWxById(Integer id);

    /**
     * 查询消息中心列表
     *
     * @param bawMessageCenterWx 消息中心
     * @return 消息中心集合
     */
    public List<BawMessageCenterWx> selectBawMessageCenterWxList(BawMessageCenterWx bawMessageCenterWx);

    /**
     * 新增消息中心
     *
     * @param bawMessageCenterWx 消息中心
     * @return 结果
     */
    public int insertBawMessageCenterWx(BawMessageCenterWx bawMessageCenterWx);

    /**
     * 修改消息中心
     *
     * @param bawMessageCenterWx 消息中心
     * @return 结果
     */
    public int updateBawMessageCenterWx(BawMessageCenterWx bawMessageCenterWx);

    /**
     * 删除消息中心
     *
     * @param id 消息中心主键
     * @return 结果
     */
    public int deleteBawMessageCenterWxById(Integer id);

    /**
     * 批量删除消息中心
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawMessageCenterWxByIds(String[] ids);



    public BawMessageCenterWx selectBawMessageCenterWx(BawMessageCenterWx bawMessageCenterWx);

    /**
     * 查询消息中心列表
     * @param userId 用户id
     * @return
     */
    public List<ModelMap> slectList (Integer userId);
}
