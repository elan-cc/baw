package com.ruoyi.web.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.BawCompanyNews;
import com.ruoyi.web.service.IBawCompanyNewsService;
import com.ruoyi.web.utils.MyDateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 企业新闻Controller
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Controller
@RequestMapping("/news/baw_company_news")
public class BawCompanyNewsController extends BaseController
{
    private String prefix = "news/baw_company_news";

    @Autowired
    private IBawCompanyNewsService bawCompanyNewsService;

    @RequiresPermissions("news:baw_company_news:view")
    @GetMapping()
    public String baw_company_news()
    {
        return prefix + "/baw_company_news";
    }

    /**
     * 查询企业新闻列表
     */
    @RequiresPermissions("news:baw_company_news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawCompanyNews bawCompanyNews)
    {
        bawCompanyNews.setIsDelete(0);
        startPage();
        List<BawCompanyNews> list = bawCompanyNewsService.selectBawCompanyNewsList(bawCompanyNews);
        return getDataTable(list);
    }

    /**
     * 导出企业新闻列表
     */
    @RequiresPermissions("news:baw_company_news:export")
    @Log(title = "企业新闻", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawCompanyNews bawCompanyNews)
    {
        bawCompanyNews.setIsDelete(0);
        List<BawCompanyNews> list = bawCompanyNewsService.selectBawCompanyNewsList(bawCompanyNews);
        ExcelUtil<BawCompanyNews> util = new ExcelUtil<BawCompanyNews>(BawCompanyNews.class);
        return util.exportExcel(list, "企业新闻数据");
    }

    /**
     * 新增企业新闻
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业新闻
     */
    @RequiresPermissions("news:baw_company_news:add")
    @Log(title = "企业新闻", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawCompanyNews bawCompanyNews)
    {
        if(bawCompanyNews.getFabuDate() == null || "".equals(bawCompanyNews.getFabuDate()))
        {
            bawCompanyNews.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawCompanyNews.setFabuDate(MyDateUtils.StringToTimestamp(bawCompanyNews.getFabuDate()+" 00:00:00")+"");
        }
        bawCompanyNews.setIsDelete(0);
        bawCompanyNews.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawCompanyNews.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawCompanyNewsService.insertBawCompanyNews(bawCompanyNews));
    }

    /**
     * 修改企业新闻
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawCompanyNews bawCompanyNews = bawCompanyNewsService.selectBawCompanyNewsById(id);
        bawCompanyNews.setFabuDate(MyDateUtils.timestampToString(Convert.toInt(bawCompanyNews.getFabuDate()),"yyyy-MM-dd"));
        mmap.put("bawCompanyNews", bawCompanyNews);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业新闻
     */
    @RequiresPermissions("news:baw_company_news:edit")
    @Log(title = "企业新闻", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawCompanyNews bawCompanyNews)
    {
        if(bawCompanyNews.getFabuDate() == null || "".equals(bawCompanyNews.getFabuDate()))
        {
            bawCompanyNews.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawCompanyNews.setFabuDate(MyDateUtils.StringToTimestamp(bawCompanyNews.getFabuDate()+" 00:00:00")+"");
        }
        return toAjax(bawCompanyNewsService.updateBawCompanyNews(bawCompanyNews));
    }

    /**
     * 删除企业新闻
     */
    @RequiresPermissions("news:baw_company_news:remove")
    @Log(title = "企业新闻", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawCompanyNewsService.deleteBawCompanyNewsByIds(ids));
    }
}
