package com.sc.api.service;

import com.sc.api.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用feign-hystrix做服务降级
 * @Author: jiangbaojun
 * @Date: 2020/2/20 13:29
 */
@Component
public class FeignDeptServiceFallbakFactory implements FallbackFactory {

    /**
     * 当服务降级时（例如远程的服务提供者已经关闭），由此处创建一个feign负载均衡接口实例，并执行相应的方法.是服务消费端处理的一种方法
     * @param throwable
     * @return com.sc.api.service.FeignDeptService
     * @Author jiangbaojun
     * @Date 2020/2/20 13:32
     */
    public FeignDeptService create(final Throwable throwable) {
        return new FeignDeptService() {
            private Throwable e = throwable;
            public boolean addDept(Dept dept) {
                return false;
            }

            /**
             * 仅测试当前方法
             * @return com.sc.api.entity.Dept
             * @Author jiangbaojun
             * @Date 2020/2/20 13:35
             */
            public Dept queryById(Long id) {
                return new Dept()
                        .setDname("id:"+id+",不存在该信息，service fallback:"+e.getMessage())
                        .setDb_source("no database on mysql");
            }

            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
