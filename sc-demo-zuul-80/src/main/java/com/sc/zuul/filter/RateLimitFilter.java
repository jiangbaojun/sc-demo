package com.sc.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 模拟一个限流过滤器
 * 查看gauva
 * @Author: jiangbaojun
 * @Date: 2020/2/27 10:57
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    //每秒生成1000个令牌
    private static final RateLimiter rateLimter = RateLimiter.create(1000);

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
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
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
        return false;
    }

    /**
     * 拦截执行的逻辑
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //判断是否能获取令牌
        if(!rateLimter.tryAcquire()){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            context.setResponseBody("访问人数太多了");
            context.getResponse().setContentType("text/html;charset=UTF-8");
        }
        return null;
    }
}
