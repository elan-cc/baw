package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
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
import com.ruoyi.web.domain.BawTopicActivity;
import com.ruoyi.web.service.IBawTopicActivityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专题活动Controller
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Controller
@RequestMapping("/news/baw_topic_activity")
public class BawTopicActivityController extends BaseController
{
    private String prefix = "news/baw_topic_activity";

    @Autowired
    private IBawTopicActivityService bawTopicActivityService;

    @RequiresPermissions("news:baw_topic_activity:view")
    @GetMapping()
    public String baw_topic_activity()
    {
        return prefix + "/baw_topic_activity";
    }

    /**
     * 查询专题活动列表
     */
    @RequiresPermissions("news:baw_topic_activity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawTopicActivity bawTopicActivity)
    {
        bawTopicActivity.setIsDelete(0);
        startPage();
        List<BawTopicActivity> list = bawTopicActivityService.selectBawTopicActivityList(bawTopicActivity);
        return getDataTable(list);
    }

    /**
     * 导出专题活动列表
     */
    @RequiresPermissions("news:baw_topic_activity:export")
    @Log(title = "专题活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawTopicActivity bawTopicActivity)
    {
        bawTopicActivity.setIsDelete(0);
        List<BawTopicActivity> list = bawTopicActivityService.selectBawTopicActivityList(bawTopicActivity);
        ExcelUtil<BawTopicActivity> util = new ExcelUtil<BawTopicActivity>(BawTopicActivity.class);
        return util.exportExcel(list, "专题活动数据");
    }

    /**
     * 新增专题活动
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专题活动
     */
    @RequiresPermissions("news:baw_topic_activity:add")
    @Log(title = "专题活动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawTopicActivity bawTopicActivity)
    {
        if(bawTopicActivity.getFabuDate() == null || "".equals(bawTopicActivity.getFabuDate()))
        {
            bawTopicActivity.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawTopicActivity.setFabuDate(MyDateUtils.StringToTimestamp(bawTopicActivity.getFabuDate()+" 00:00:00")+"");
        }
        bawTopicActivity.setIsDelete(0);
        bawTopicActivity.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawTopicActivity.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawTopicActivityService.insertBawTopicActivity(bawTopicActivity));
    }

    /**
     * 修改专题活动
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawTopicActivity bawTopicActivity = bawTopicActivityService.selectBawTopicActivityById(id);
        bawTopicActivity.setFabuDate(MyDateUtils.timestampToString(Convert.toInt(bawTopicActivity.getFabuDate()),"yyyy-MM-dd"));
        mmap.put("bawTopicActivity", bawTopicActivity);
        return prefix + "/edit";
    }

    /**
     * 修改保存专题活动
     */
    @RequiresPermissions("news:baw_topic_activity:edit")
    @Log(title = "专题活动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawTopicActivity bawTopicActivity)
    {
        if(bawTopicActivity.getFabuDate() == null || "".equals(bawTopicActivity.getFabuDate()))
        {
            bawTopicActivity.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawTopicActivity.setFabuDate(MyDateUtils.StringToTimestamp(bawTopicActivity.getFabuDate()+" 00:00:00")+"");
        }
        return toAjax(bawTopicActivityService.updateBawTopicActivity(bawTopicActivity));
    }

    /**
     * 删除专题活动
     */
    @RequiresPermissions("news:baw_topic_activity:remove")
    @Log(title = "专题活动", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawTopicActivityService.deleteBawTopicActivityByIds(ids));
    }
}
