package com.ruoyi.web.service.impl;

import java.util.*;

import com.ruoyi.web.domain.BawVehicleOrderingWx;
import com.ruoyi.web.mapper.BawBaseCarSeriesMapper;
import com.ruoyi.web.mapper.BawBaseCarTypeMapper;
import com.ruoyi.web.mapper.BawVehicleOrderingWxMapper;
import com.ruoyi.web.service.IBawVehicleOrderingWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 车辆订购管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class BawVehicleOrderingWxServiceImpl implements IBawVehicleOrderingWxService
{
    @Autowired
    private BawVehicleOrderingWxMapper bawVehicleOrderingWxMapper;
    @Autowired
    private BawBaseCarSeriesMapper bawBaseCarSeriesMapper;
    @Autowired
    private BawBaseCarTypeMapper bawBaseCarTypeMapper;

    /**
     * 查询车辆订购管理
     *
     * @param id 车辆订购管理主键
     * @return 车辆订购管理
     */
    @Override
    public BawVehicleOrderingWx selectBawVehicleOrderingWxById(Integer id)
    {
        return bawVehicleOrderingWxMapper.selectBawVehicleOrderingWxById(id);
    }

    /**
     * 查询车辆订购管理列表
     *
     * @param bawVehicleOrderingWx 车辆订购管理
     * @return 车辆订购管理
     */
    @Override
    public List<BawVehicleOrderingWx> selectBawVehicleOrderingWxList(BawVehicleOrderingWx bawVehicleOrderingWx)
    {
        return bawVehicleOrderingWxMapper.selectBawVehicleOrderingWxList(bawVehicleOrderingWx);
    }

    /**
     * 新增车辆订购管理
     *
     * @param bawVehicleOrderingWx 车辆订购管理
     * @return 结果
     */
    @Override
    public int insertBawVehicleOrderingWx(BawVehicleOrderingWx bawVehicleOrderingWx)
    {
        String s = bawBaseCarSeriesMapper.selectCarSeriesCodeByCode(bawVehicleOrderingWx.getCarSeriesCode());
        bawVehicleOrderingWx.setCarSeriesName(s);
        return bawVehicleOrderingWxMapper.insertBawVehicleOrderingWx(bawVehicleOrderingWx);
    }

    /**
     * 修改车辆订购管理
     *
     * @param bawVehicleOrderingWx 车辆订购管理
     * @return 结果
     */
    @Override
    public int updateBawVehicleOrderingWx(BawVehicleOrderingWx bawVehicleOrderingWx)
    {
        String s = bawBaseCarSeriesMapper.selectCarSeriesCodeByCode(bawVehicleOrderingWx.getCarSeriesCode());
        bawVehicleOrderingWx.setCarSeriesName(s);
        return bawVehicleOrderingWxMapper.updateBawVehicleOrderingWx(bawVehicleOrderingWx);
    }

    /**
     * 批量删除车辆订购管理
     *
     * @param ids 需要删除的车辆订购管理主键
     * @return 结果
     */
    @Override
    public int deleteBawVehicleOrderingWxByIds(String ids)
    {
        return bawVehicleOrderingWxMapper.deleteBawVehicleOrderingWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆订购管理信息
     *
     * @param id 车辆订购管理主键
     * @return 结果
     */
    @Override
    public int deleteBawVehicleOrderingWxById(Integer id)
    {
        return bawVehicleOrderingWxMapper.deleteBawVehicleOrderingWxById(id);
    }
    /**
     * 查看列表信息
     *
     * @param code 车系code
     * @return 结果
     */
    @Override
    public List<Map<String, Object>> selectList(String code) {
        List<Map<String,Object>> resultList = new ArrayList<>();
        List<BawVehicleOrderingWx> bawVehicleOrderingWxes = bawVehicleOrderingWxMapper.selectList(code);
        for (BawVehicleOrderingWx bawVehicleOrderingWx : bawVehicleOrderingWxes) {
            Map<String,Object> map = new HashMap<>();
            map.put("carSeriesCode",bawVehicleOrderingWx.getCarSeriesCode());
            map.put("carSeriesName",bawVehicleOrderingWx.getCarSeriesName());
            map.put("modelCode",bawVehicleOrderingWx.getModelCode());
            map.put("modelName",bawVehicleOrderingWx.getModelName());
            List<BawVehicleOrderingWx> bawVehicleOrderingWxes1 = bawVehicleOrderingWxMapper.selectColor(bawVehicleOrderingWx.getModelCode());
            List<Map<String,Object>> colorList = new ArrayList<>();
            for (BawVehicleOrderingWx vehicleOrderingWx : bawVehicleOrderingWxes1) {
                Map<String ,Object> maps = new HashMap<>();
                maps.put("color",vehicleOrderingWx.getColor());
                maps.put("colorId",vehicleOrderingWx.getColorId());
                maps.put("colorValue",vehicleOrderingWx.getColorValue());
                maps.put("price",vehicleOrderingWx.getPrice());
                maps.put("guidancePrice",vehicleOrderingWx.getGuidancePrice());
                maps.put("picture",vehicleOrderingWx.getPicture());
                colorList.add(maps);
            }
            map.put("colors",colorList);
            resultList.add(map);
        }
        return resultList;
    }
}
