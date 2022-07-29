package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawVehicleOrderingWx;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 车辆订购管理Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface BawVehicleOrderingWxMapper
{
    /**
     * 查询车辆订购管理
     *
     * @param id 车辆订购管理主键
     * @return 车辆订购管理
     */
    public BawVehicleOrderingWx selectBawVehicleOrderingWxById(Integer id);

    /**
     * 查询车辆订购管理列表
     *
     * @param bawVehicleOrderingWx 车辆订购管理
     * @return 车辆订购管理集合
     */
    public List<BawVehicleOrderingWx> selectBawVehicleOrderingWxList(BawVehicleOrderingWx bawVehicleOrderingWx);

    /**
     * 新增车辆订购管理
     *
     * @param bawVehicleOrderingWx 车辆订购管理
     * @return 结果
     */
    public int insertBawVehicleOrderingWx(BawVehicleOrderingWx bawVehicleOrderingWx);

    /**
     * 修改车辆订购管理
     *
     * @param bawVehicleOrderingWx 车辆订购管理
     * @return 结果
     */
    public int updateBawVehicleOrderingWx(BawVehicleOrderingWx bawVehicleOrderingWx);

    /**
     * 删除车辆订购管理
     *
     * @param id 车辆订购管理主键
     * @return 结果
     */
    public int deleteBawVehicleOrderingWxById(Integer id);

    /**
     * 批量删除车辆订购管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawVehicleOrderingWxByIds(String[] ids);

    public List<BawVehicleOrderingWx> selectList(String code);


    public List<BawVehicleOrderingWx> selectColor(String code);
}
