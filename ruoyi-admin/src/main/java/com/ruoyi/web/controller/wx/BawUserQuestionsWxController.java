package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.controller.wx.utils.Utils;
import com.ruoyi.web.domain.BawUserQuestionsWx;
import com.ruoyi.web.service.IBawUserQuestionsWxService;
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

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户提问Controller
 *
 * @author ruoyi
 * @date 2022-04-20
 */
@Controller
@RequestMapping("/wx/baw_user_questions_wx")
public class BawUserQuestionsWxController extends BaseController
{
    private String prefix = "wx/baw_user_questions_wx";

    @Autowired
    private IBawUserQuestionsWxService bawUserQuestionsWxService;

    @RequiresPermissions("wx:baw_user_questions_wx:view")
    @GetMapping()
    public String baw_user_questions_wx()
    {
        return prefix + "/baw_user_questions_wx";
    }

    /**
     * 查询用户提问列表
     */
    @RequiresPermissions("wx:baw_user_questions_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawUserQuestionsWx bawUserQuestionsWx)
    {
        startPage();
        List<BawUserQuestionsWx> list = bawUserQuestionsWxService.selectBawUserQuestionsWxList(bawUserQuestionsWx);
        return getDataTable(list);
    }

    /**
     * 导出用户提问列表
     */
    @RequiresPermissions("wx:baw_user_questions_wx:export")
    @Log(title = "用户提问", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawUserQuestionsWx bawUserQuestionsWx)
    {
        List<BawUserQuestionsWx> list = bawUserQuestionsWxService.selectBawUserQuestionsWxList(bawUserQuestionsWx);
        ExcelUtil<BawUserQuestionsWx> util = new ExcelUtil<BawUserQuestionsWx>(BawUserQuestionsWx.class);
        return util.exportExcel(list, "用户提问数据");
    }

    /**
     * 新增用户提问
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户提问
     */
    @RequiresPermissions("wx:baw_user_questions_wx:add")
    @Log(title = "用户提问", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawUserQuestionsWx bawUserQuestionsWx)
    {
        if (!Utils.telephone(bawUserQuestionsWx.getTelephone())){
            return AjaxResult.error("请输入正确的手机号码");
        }
        return toAjax(bawUserQuestionsWxService.insertBawUserQuestionsWx(bawUserQuestionsWx));
    }

    /**
     * 修改用户提问
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawUserQuestionsWx bawUserQuestionsWx = bawUserQuestionsWxService.selectBawUserQuestionsWxById(id);
        mmap.put("bawUserQuestionsWx", bawUserQuestionsWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户提问
     */
    @RequiresPermissions("wx:baw_user_questions_wx:edit")
    @Log(title = "用户提问", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawUserQuestionsWx bawUserQuestionsWx)
    {
        return toAjax(bawUserQuestionsWxService.updateBawUserQuestionsWx(bawUserQuestionsWx));
    }

    /**
     * 删除用户提问
     */
    @RequiresPermissions("wx:baw_user_questions_wx:remove")
    @Log(title = "用户提问", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawUserQuestionsWxService.deleteBawUserQuestionsWxByIds(ids));
    }
}
