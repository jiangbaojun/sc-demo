package com.sc.zuul.consul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 模拟一个登录过滤器
 * 查看jwt 和 acl访问控制列表
 * @Author: jiangbaojun
 * @Date: 2020/2/27 10:57
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 类型 pre
     * pre：路由请求前过滤。
     * post：路由请求后(此时已经走完目标服务程序了)过滤。
     * route：路由请求时过滤。
     * error：当上述三种过滤器抛出异常时，会走error过滤。
     */
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 执行顺数,数字小先执行
     */
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 是否开启该过滤
     * @return
     */
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String uri = request.getRequestURI();
        //可以根据url判断是否要开启
        if("/mydept/provider/dept/get/1".equals(uri)){
            return true;
        }
        return true;
    }

    /**
     * 拦截执行的逻辑
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println(id);
        System.out.println(session.getAttribute("aa"));

        session.setAttribute("zuulconsul", "123");

        //判断head中token是否存在
//        String token = request.getHeader("token");
//        if(StringUtils.isBlank(token)){
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
//            context.setResponseBody("身份验证失败");
//            context.getResponse().setContentType("text/html;charset=UTF-8");
//        }
        return null;
    }
}
