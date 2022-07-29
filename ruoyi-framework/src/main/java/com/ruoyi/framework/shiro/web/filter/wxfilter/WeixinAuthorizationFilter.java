package com.ruoyi.framework.shiro.web.filter.wxfilter;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author zhuhe
 * @date 2022年03月12日 17:28
 */
public class WeixinAuthorizationFilter extends AuthorizationFilter {
	@Override
	protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
		 /*  HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        if (StringUtils.isBlank(token)){
            // token 为空
            response.setContentType("application/json; charset=utf-8");//返回json
            response.getWriter().write(JSON.toJSONString(AjaxResult.error( "用户未登录，请先登录")));
        } else if (StringUtils.isNull(CacheUtils.get(token))){
            // 通过token在缓存中没有查询到相关用户信息
            response.setContentType("application/json; charset=utf-8");//返回json
            response.getWriter().write(JSON.toJSONString(AjaxResult.error( "用户未登录，请先登录")));
        }*/
		/*servletResponse.setCharacterEncoding("UTF-8");
		servletResponse.setContentType("application/json;charset=UTF-8");
		servletResponse.getWriter().print(JSON.toJSONString(AjaxResult.error( "用户未登录，请先登录")));
		servletResponse.getWriter().flush();*/
		return true;
	}
}
