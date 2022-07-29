package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawInformationEnterpriseMapper;
import com.ruoyi.web.domain.BawInformationEnterprise;
import com.ruoyi.web.service.IBawInformationEnterpriseService;
import com.ruoyi.common.core.text.Convert;

/**
 * baw_information_enterpriseService业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-17
 */
@Service
public class BawInformationEnterpriseServiceImpl implements IBawInformationEnterpriseService 
{
    @Autowired
    private BawInformationEnterpriseMapper bawInformationEnterpriseMapper;

    /**
     * 查询baw_information_enterprise
     * 
     * @param id baw_information_enterprise主键
     * @return baw_information_enterprise
     */
    @Override
    public BawInformationEnterprise selectBawInformationEnterpriseById(Long id)
    {
        return bawInformationEnterpriseMapper.selectBawInformationEnterpriseById(id);
    }

    /**
     * 查询baw_information_enterprise列表
     * 
     * @param bawInformationEnterprise baw_information_enterprise
     * @return baw_information_enterprise
     */
    @Override
    public List<BawInformationEnterprise> selectBawInformationEnterpriseList(BawInformationEnterprise bawInformationEnterprise)
    {
        return bawInformationEnterpriseMapper.selectBawInformationEnterpriseList(bawInformationEnterprise);
    }

    /**
     * 新增baw_information_enterprise
     * 
     * @param bawInformationEnterprise baw_information_enterprise
     * @return 结果
     */
    @Override
    public int insertBawInformationEnterprise(BawInformationEnterprise bawInformationEnterprise)
    {
        bawInformationEnterprise.setCreateTime(DateUtils.getNowDate());
        return bawInformationEnterpriseMapper.insertBawInformationEnterprise(bawInformationEnterprise);
    }

    /**
     * 修改baw_information_enterprise
     * 
     * @param bawInformationEnterprise baw_information_enterprise
     * @return 结果
     */
    @Override
    public int updateBawInformationEnterprise(BawInformationEnterprise bawInformationEnterprise)
    {
        bawInformationEnterprise.setUpdateTime(DateUtils.getNowDate());
        return bawInformationEnterpriseMapper.updateBawInformationEnterprise(bawInformationEnterprise);
    }

    /**
     * 批量删除baw_information_enterprise
     * 
     * @param ids 需要删除的baw_information_enterprise主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationEnterpriseByIds(String ids)
    {
        return bawInformationEnterpriseMapper.deleteBawInformationEnterpriseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除baw_information_enterprise信息
     * 
     * @param id baw_information_enterprise主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationEnterpriseById(Long id)
    {
        return bawInformationEnterpriseMapper.deleteBawInformationEnterpriseById(id);
    }
}
