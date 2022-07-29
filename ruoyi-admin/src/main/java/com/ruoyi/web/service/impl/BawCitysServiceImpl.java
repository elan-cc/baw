package com.ruoyi.web.service.impl;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.utils.PinYinUtils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawCitysMapper;
import com.ruoyi.web.domain.BawCitys;
import com.ruoyi.web.service.IBawCitysService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 经销商城市Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-15
 */
@Service
public class BawCitysServiceImpl implements IBawCitysService
{
    @Autowired
    private BawCitysMapper bawCitysMapper;

    /**
     * 查询经销商城市
     *
     * @param id 经销商城市主键
     * @return 经销商城市
     */
    @Override
    public BawCitys selectBawCitysById(Integer id)
    {
        return bawCitysMapper.selectBawCitysById(id);
    }

    /**
     * 查询经销商城市列表
     *
     * @param bawCitys 经销商城市
     * @return 经销商城市
     */
    @Override
    public List<BawCitys> selectBawCitysList(BawCitys bawCitys)
    {
        return bawCitysMapper.selectBawCitysList(bawCitys);
    }

    /**
     * 查询经销商省份列表For API
     *
     * @return 经销商省份集合
     */
    @Override
    public List<ModelMap> selectProvinceForApi(Integer isDelete, Integer isDisable) {
        return bawCitysMapper.selectProvinceForApi(isDelete, isDisable);
    }

    /**
     * 查询经销商城市列表For API
     *
     * @return 经销商城市集合
     */
    @Override
    public List<ModelMap> selectCityForApi(Integer isDelete, Integer isDisable, String province) {
        return bawCitysMapper.selectCityForApi(isDelete, isDisable, province);
    }

    /**
     * 新增经销商城市
     *
     * @param bawCitys 经销商城市
     * @return 结果
     */
    @Override
    public int insertBawCitys(BawCitys bawCitys)
    {
        return bawCitysMapper.insertBawCitys(bawCitys);
    }

    /**
     * 修改经销商城市
     *
     * @param bawCitys 经销商城市
     * @return 结果
     */
    @Override
    public int updateBawCitys(BawCitys bawCitys)
    {
        return bawCitysMapper.updateBawCitys(bawCitys);
    }

    /**
     * 批量删除经销商城市
     *
     * @param ids 需要删除的经销商城市主键
     * @return 结果
     */
    @Override
    public int deleteBawCitysByIds(String ids)
    {
        return bawCitysMapper.deleteBawCitysByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除经销商城市信息
     *
     * @param id 经销商城市主键
     * @return 结果
     */
    @Override
    public int deleteBawCitysById(Integer id)
    {
        return bawCitysMapper.deleteBawCitysById(id);
    }
    
    @Override
    public List<ModelMap> selectCitySort(String city) {
        return bawCitysMapper.selectCitys(0, 0, city);
    }
    
   
}
