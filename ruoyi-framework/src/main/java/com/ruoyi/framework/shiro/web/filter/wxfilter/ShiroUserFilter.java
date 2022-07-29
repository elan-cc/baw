package com.ruoyi.framework.shiro.web.filter.wxfilter;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.common.utils.StringUtils;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhuhe
 */
public class ShiroUserFilter extends UserFilter {
    
 
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        /*if (StringUtils.isBlank(token)){
            // token 为空
            response.setContentType("application/json; charset=utf-8");//返回json
            response.getWriter().write(JSON.toJSONString(AjaxResult.error( "用户未登录，请先登录")));
        } else if (StringUtils.isNull(CacheUtils.get(token))){
            // 通过token在缓存中没有查询到相关用户信息
            response.setContentType("application/json; charset=utf-8");//返回json
            response.getWriter().write(JSON.toJSONString(AjaxResult.error( "用户未登录，请先登录")));
        } else {
            new WeixinAuthorizationFilter();
        }*/
        new WeixinAuthorizationFilter();
    }
}
