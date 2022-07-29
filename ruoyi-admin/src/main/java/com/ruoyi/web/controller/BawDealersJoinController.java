package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.utils.MyDateUtils;
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
import com.ruoyi.web.domain.BawDealersJoin;
import com.ruoyi.web.service.IBawDealersJoinService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 经销商加盟Controller
 * 
 * @author ruoyi
 * @date 2021-12-15
 */
@Controller
@RequestMapping("/company/baw_dealers_join")
public class BawDealersJoinController extends BaseController
{
    private String prefix = "company/baw_dealers_join";

    @Autowired
    private IBawDealersJoinService bawDealersJoinService;

    @RequiresPermissions("company:baw_dealers_join:view")
    @GetMapping()
    public String baw_dealers_join()
    {
        return prefix + "/baw_dealers_join";
    }

    /**
     * 查询经销商加盟列表
     */
    @RequiresPermissions("company:baw_dealers_join:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawDealersJoin bawDealersJoin)
    {
        bawDealersJoin.setIsDelete(0);
        startPage();
        List<BawDealersJoin> list = bawDealersJoinService.selectBawDealersJoinList(bawDealersJoin);
        return getDataTable(list);
    }

    /**
     * 导出经销商加盟列表
     */
    @RequiresPermissions("company:baw_dealers_join:export")
    @Log(title = "经销商加盟", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawDealersJoin bawDealersJoin)
    {
        bawDealersJoin.setIsDelete(0);
        List<BawDealersJoin> list = bawDealersJoinService.selectBawDealersJoinList(bawDealersJoin);
        ExcelUtil<BawDealersJoin> util = new ExcelUtil<BawDealersJoin>(BawDealersJoin.class);
        return util.exportExcel(list, "经销商加盟数据");
    }

    /**
     * 新增经销商加盟
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存经销商加盟
     */
    @RequiresPermissions("company:baw_dealers_join:add")
    @Log(title = "经销商加盟", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawDealersJoin bawDealersJoin)
    {
        bawDealersJoin.setIsDelete(0);
        bawDealersJoin.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawDealersJoin.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawDealersJoinService.insertBawDealersJoin(bawDealersJoin));
    }

    /**
     * 修改经销商加盟
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawDealersJoin bawDealersJoin = bawDealersJoinService.selectBawDealersJoinById(id);
        mmap.put("bawDealersJoin", bawDealersJoin);
        return prefix + "/edit";
    }

    /**
     * 修改保存经销商加盟
     */
    @RequiresPermissions("company:baw_dealers_join:edit")
    @Log(title = "经销商加盟", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawDealersJoin bawDealersJoin)
    {
        return toAjax(bawDealersJoinService.updateBawDealersJoin(bawDealersJoin));
    }

    /**
     * 删除经销商加盟
     */
    @RequiresPermissions("company:baw_dealers_join:remove")
    @Log(title = "经销商加盟", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawDealersJoinService.deleteBawDealersJoinByIds(ids));
    }
}
