package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawInformationEnterprise;

/**
 * baw_information_enterpriseMapper接口
 * 
 * @author ruoyi
 * @date 2022-01-17
 */
public interface BawInformationEnterpriseMapper 
{
    /**
     * 查询baw_information_enterprise
     * 
     * @param id baw_information_enterprise主键
     * @return baw_information_enterprise
     */
    public BawInformationEnterprise selectBawInformationEnterpriseById(Long id);

    /**
     * 查询baw_information_enterprise列表
     * 
     * @param bawInformationEnterprise baw_information_enterprise
     * @return baw_information_enterprise集合
     */
    public List<BawInformationEnterprise> selectBawInformationEnterpriseList(BawInformationEnterprise bawInformationEnterprise);

    /**
     * 新增baw_information_enterprise
     * 
     * @param bawInformationEnterprise baw_information_enterprise
     * @return 结果
     */
    public int insertBawInformationEnterprise(BawInformationEnterprise bawInformationEnterprise);

    /**
     * 修改baw_information_enterprise
     * 
     * @param bawInformationEnterprise baw_information_enterprise
     * @return 结果
     */
    public int updateBawInformationEnterprise(BawInformationEnterprise bawInformationEnterprise);

    /**
     * 删除baw_information_enterprise
     * 
     * @param id baw_information_enterprise主键
     * @return 结果
     */
    public int deleteBawInformationEnterpriseById(Long id);

    /**
     * 批量删除baw_information_enterprise
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawInformationEnterpriseByIds(String[] ids);
}
