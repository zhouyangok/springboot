/*
package com.crazyang.core.security;


import com.hong610.security.service.MyPermissionEvaluator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

*/
/**
 * @ClassName WebMvcConfigurationSupport
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 上午10:38.
 *//*

@Configurable
public class WebMvcConfigurationSupport extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return defaultMethodSecurityExpressionHandler();
    }

    @Bean
    public DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler() {
        DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler = new DefaultMethodSecurityExpressionHandler();
        defaultMethodSecurityExpressionHandler.setPermissionEvaluator(myPermissionEvaluator());
        return defaultMethodSecurityExpressionHandler;
    }

    */
/**
     * 使用hasPermission自定义验证
     *//*

    @Bean
    MyPermissionEvaluator myPermissionEvaluator() {
        MyPermissionEvaluator myPermissionEvaluator = new MyPermissionEvaluator();
        return myPermissionEvaluator;
    }

}*/
