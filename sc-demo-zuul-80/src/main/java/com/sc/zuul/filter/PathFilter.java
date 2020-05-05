package com.sc.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取路由信息
 * @Author: jiangbaojun
 * @Date: 2020/2/27 10:57
 */
@Component
public class PathFilter extends ZuulFilter {

    @Autowired
    private RouteLocator routeLocator;

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
     * 执行顺数
     */
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-2;
    }

    /**
     * 是否开启该过滤
     * @return
     */
    public boolean shouldFilter() {
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

        String requestURI = request.getRequestURI();
        //route中含有本次路由跳转的信息
        Route route = routeLocator.getMatchingRoute(requestURI);
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String basePath = scheme + "://" + serverName + ":" + port + route.getPrefix();
        String rootPath = scheme + "://" + serverName + ":" + port + request.getContextPath();
        //目标微服务的根据路径
        request.setAttribute("basePath", basePath);
        //当前网关的根路径
        request.setAttribute("rootPath", rootPath);
        return null;
    }
}
