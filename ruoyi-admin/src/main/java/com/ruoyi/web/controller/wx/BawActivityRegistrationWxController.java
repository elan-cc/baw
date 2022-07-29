package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawActivityRegistrationWx;
import com.ruoyi.web.domain.BawActivityWx;
import com.ruoyi.web.domain.BawBaseDealershop;
import com.ruoyi.web.service.IBawActivityWxService;
import com.ruoyi.web.service.IBawBaseDealershopService;
import com.ruoyi.web.service.IBawCitysService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.service.IBawActivityRegistrationWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动报名Controller
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Controller
@RequestMapping("/wx/baw_activity_registration_wx")
public class BawActivityRegistrationWxController extends BaseController
{
    private String prefix = "wx/baw_activity_registration_wx";

    @Autowired
    private IBawActivityRegistrationWxService bawActivityRegistrationWxService;
    @Autowired
    private IBawActivityWxService bawActivityWxService;
    @Autowired
    private IBawCitysService citysService;
    @Autowired
    private IBawBaseDealershopService bawBaseDealershopService;

    @RequiresPermissions("wx:baw_activity_registration_wx:view")
    @GetMapping()
    public String baw_activity_registration_wx()
    {
        return prefix + "/baw_activity_registration_wx";
    }

    /**
     * 查询活动报名列表
     */
    @RequiresPermissions("wx:baw_activity_registration_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawActivityRegistrationWx bawActivityRegistrationWx)
    {
        startPage();
        List<BawActivityRegistrationWx> list = bawActivityRegistrationWxService.selectBawActivityRegistrationWxList(bawActivityRegistrationWx);
        return getDataTable(list);
    }

    /**
     * 导出活动报名列表
     */
    @RequiresPermissions("wx:baw_activity_registration_wx:export")
    @Log(title = "活动报名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawActivityRegistrationWx bawActivityRegistrationWx)
    {
        List<BawActivityRegistrationWx> list = bawActivityRegistrationWxService.selectBawActivityRegistrationWxList(bawActivityRegistrationWx);
        for (BawActivityRegistrationWx registrationWx : list) {
            Integer activityId = registrationWx.getActivityId();
            BawActivityWx bawActivityWx = bawActivityWxService.selectBawActivityWxById(activityId);
            if (StringUtils.isNotNull(bawActivityWx)){
                registrationWx.setActivityName(bawActivityWx.getActivityTitle());
            } else {
                registrationWx.setActivityName("");
            }
            List<BawBaseDealershop> bawBaseDealershops = bawBaseDealershopService.selectBawBaseDealershopByDlrCode(registrationWx.getDealerCode());
            if (null != bawBaseDealershops && bawBaseDealershops.size() > 0){
                registrationWx.setDealerCodeName(bawBaseDealershops.get(0).getNameOrg1());
            } else {
                registrationWx.setDealerCodeName("");
            }
        }
        ExcelUtil<BawActivityRegistrationWx> util = new ExcelUtil<BawActivityRegistrationWx>(BawActivityRegistrationWx.class);
        return util.exportExcel(list, "活动报名数据");
    }

    /**
     * 新增活动报名
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存活动报名
     */
    @RequiresPermissions("wx:baw_activity_registration_wx:add")
    @Log(title = "活动报名", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawActivityRegistrationWx bawActivityRegistrationWx)
    {
        return null;
    }

    /**
     * 修改活动报名
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawActivityRegistrationWx bawActivityRegistrationWx = bawActivityRegistrationWxService.selectBawActivityRegistrationWxById(id);
        mmap.put("bawActivityRegistrationWx", bawActivityRegistrationWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存活动报名
     */
    @RequiresPermissions("wx:baw_activity_registration_wx:edit")
    @Log(title = "活动报名", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawActivityRegistrationWx bawActivityRegistrationWx)
    {
        return toAjax(bawActivityRegistrationWxService.updateBawActivityRegistrationWx(bawActivityRegistrationWx));
    }

    /**
     * 删除活动报名
     */
    @RequiresPermissions("wx:baw_activity_registration_wx:remove")
    @Log(title = "活动报名", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawActivityRegistrationWxService.deleteBawActivityRegistrationWxByIds(ids));
    }
}
