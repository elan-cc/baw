package com.ruoyi.web.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawActivityClassification;
import com.ruoyi.web.mapper.BawActivityClassificationMapper;
import com.ruoyi.web.service.IBawActivityClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 活动分类Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-25
 */
@Service
public class BawActivityClassificationServiceImpl implements IBawActivityClassificationService {
    @Autowired
    private BawActivityClassificationMapper bawActivityClassificationMapper;

    /**
     * 查询活动分类
     *
     * @param id 活动分类主键
     * @return 活动分类
     */
    @Override
    public BawActivityClassification selectBawActivityClassificationById(Integer id) {
        return bawActivityClassificationMapper.selectBawActivityClassificationById(id);
    }

    /**
     * 查询活动分类列表
     *
     * @param bawActivityClassification 活动分类
     * @return 活动分类
     */
    @Override
    public List<BawActivityClassification> selectBawActivityClassificationList(BawActivityClassification bawActivityClassification) {
        return bawActivityClassificationMapper.selectBawActivityClassificationList(bawActivityClassification);
    }

    /**
     * 新增活动分类
     *
     * @param bawActivityClassification 活动分类
     * @return 结果
     */
    @Override
    public int insertBawActivityClassification(BawActivityClassification bawActivityClassification) {
        bawActivityClassification.setCearteTime(new Date());
        return bawActivityClassificationMapper.insertBawActivityClassification(bawActivityClassification);
    }

    /**
     * 修改活动分类
     *
     * @param bawActivityClassification 活动分类
     * @return 结果
     */
    @Override
    public int updateBawActivityClassification(BawActivityClassification bawActivityClassification) {
        bawActivityClassification.setUpdateTime(DateUtils.getNowDate());
        return bawActivityClassificationMapper.updateBawActivityClassification(bawActivityClassification);
    }

    /**
     * 批量删除活动分类
     *
     * @param ids 需要删除的活动分类主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityClassificationByIds(String ids) {
        return bawActivityClassificationMapper.deleteBawActivityClassificationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动分类信息
     *
     * @param id 活动分类主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityClassificationById(Integer id) {
        return bawActivityClassificationMapper.deleteBawActivityClassificationById(id);
    }

    @Override
    public List<ModelMap> classIficartionList() {
        List<ModelMap> modelMaps = bawActivityClassificationMapper.classIficartionList();
        return modelMaps;
    }
}
