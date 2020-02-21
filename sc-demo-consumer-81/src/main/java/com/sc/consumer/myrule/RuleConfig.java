package com.sc.consumer.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon规则配置。该文件要放在启动文件包的外层。在启动类上通过注解RibbonClient注解指定该配置
 * @Author: jiangbaojun
 * @Date: 2020/2/19 20:27
 */
@Configuration
public class RuleConfig {

    @Bean
    public IRule getIRule(){
        return new MyRibbonRule();
    }
}


