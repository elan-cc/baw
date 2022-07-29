package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawInformationOfficialWx;
import org.apache.ibatis.annotations.Param;

/**
 * 官方资讯Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface BawInformationOfficialWxMapper {
    /**
     * 查询官方资讯
     *
     * @param id 官方资讯主键
     * @return 官方资讯
     */
    public BawInformationOfficialWx selectBawInformationOfficialWxById(Integer id);

    /**
     * 查询官方资讯列表
     *
     * @param bawInformationOfficialWx 官方资讯
     * @return 官方资讯集合
     */
    public List<BawInformationOfficialWx> selectBawInformationOfficialWxList(BawInformationOfficialWx bawInformationOfficialWx);

    /**
     * 新增官方资讯
     *
     * @param bawInformationOfficialWx 官方资讯
     * @return 结果
     */
    public int insertBawInformationOfficialWx(BawInformationOfficialWx bawInformationOfficialWx);

    /**
     * 修改官方资讯
     *
     * @param bawInformationOfficialWx 官方资讯
     * @return 结果
     */
    public int updateBawInformationOfficialWx(BawInformationOfficialWx bawInformationOfficialWx);

    /**
     * 删除官方资讯
     *
     * @param id 官方资讯主键
     * @return 结果
     */
    public int deleteBawInformationOfficialWxById(Integer id);

    /**
     * 批量删除官方资讯
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawInformationOfficialWxByIds(String[] ids);

    /**
     * 查询焦点个数
     *
     * @return
     */
    int selectBawInformationOfficialWxFocusCount();

    /**
     * 查询咨询
     *
     * @param infoOfficalId 咨询id
     * @return
     */
    BawInformationOfficialWx selectById(Integer infoOfficalId);

    /**
     * 增加浏览量
     *
     * @param infoOfficalId 咨询id
     */
    void addViewCount(@Param("infoOfficalId") Integer infoOfficalId);

    /**
     * 查询咨询列表
     *
     * @param focus
     * @return
     */
    List<BawInformationOfficialWx> getInfoOfficialList(@Param("focus") Integer focus, @Param("type") Integer type);

    /**
     * 取消点赞
     * @param infoOfficalId 咨询id
     */
    void cancelInformationOfficialList(Integer infoOfficalId);

    /**
     * 点赞
     * @param infoOfficalId 咨询id
     * @return
     */
    int informationOfficialList(@Param("infoOfficalId") Integer infoOfficalId);
    
    void share(Integer id);
}
