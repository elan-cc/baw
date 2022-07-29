package com.ruoyi.framework.shiro.web.filter.wxfilter;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.common.utils.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhuhe
 * @date 2022年03月14日 8:54
 */
public class MyFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("token");
        if (StringUtils.isBlank(token)){
            // token 为空
            response.setContentType("application/json; charset=utf-8");//返回json
            response.getWriter().write(JSON.toJSONString(AjaxResult.error( "用户未登录，请先登录")));
        } else if (StringUtils.isNull(CacheUtils.get(token))){
            // 通过token在缓存中没有查询到相关用户信息
            response.setContentType("application/json; charset=utf-8");//返回json
            response.getWriter().write(JSON.toJSONString(AjaxResult.error( "用户未登录，请先登录")));
        } else {
            filterChain.doFilter(request,response);
        }
		
	}
}
