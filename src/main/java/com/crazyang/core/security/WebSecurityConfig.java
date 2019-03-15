/*
package com.crazyang.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


*/
/**
 * @ClassName WebSecurityConfig
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 上午10:18.
 * ")
 * .antMatchers("/captcha.jpg");
 * }
 * @Autowired protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 * auth.authenticationProvider(myAuthenticationProvider());
 * }
 * <p>
 * <p>
 * SpringSecurity User Service
 * <p>
 * 退出之后的处理
 * <p>
 * 自定义验证
 * <p>
 * session管理
 * <p>
 * 登录成功
 * <p>
 * 自定义权限验证
 *//*

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()//拦截页面
                .anyRequest().authenticated()//全部页面都要验证
        ;//.accessDecisionManager(accessDecisionManagerService());//使用自定义拦截

        http.csrf()//禁用csrf - 使用自定义登录页面
                .disable();

        http.formLogin()//登录
                .loginPage("/account/login.html")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/index.html")//先defaultSuccessUrl后successHandler，不然successHandler不会执行
                .successHandler(myLoginSuccessHandler())
                .withObjectPostProcessor(new ObjectPostProcessor<UsernamePasswordAuthenticationFilter>() {//高级设置-拦截器
                    public <O extends UsernamePasswordAuthenticationFilter> O postProcess(O fsi) {
                        return fsi;
                    }

                })
                .permitAll();

        http.logout()//登出
                .logoutUrl("/account/logout.html")
                .logoutSuccessUrl("/account/login.html")
                .logoutSuccessHandler(myLogoutSuccessHandler())
                .deleteCookies("remeber-me")
                .permitAll();

        http.rememberMe()//记住我
                .rememberMeCookieName("remeber-me")
                .userDetailsService(userDetailService());

        http.sessionManagement()//Session管理器
                .sessionFixation().changeSessionId()
                .sessionAuthenticationErrorUrl("/account/login.html")
                .invalidSessionUrl("/account/login.html")//Session失效
                .maximumSessions(1)//只能同时一个人在线
                .sessionRegistry(mySessionRegistry())//启用这个让maximumSessions生效
                .expiredUrl("/account/login.html");

        http.exceptionHandling()//权限验证失败进入的页面（只对使用自定义拦截有效）
                .accessDeniedPage("/access_denied.html");

        http.headers()//允许同源iframe访问
                .frameOptions()
                .sameOrigin();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //Web层面的拦截，用来跳过的资源
        web.ignoring()
                .antMatchers("*/
/**//*
favicon.ico")
                .antMatchers("/assets*/
/**")
 .antMatchers("/captcha.jpg");
 }

 @Autowired protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 auth.authenticationProvider(myAuthenticationProvider());
 }

 */
/**
 * SpringSecurity User Service
 *//*

    @Bean
    UserDetailService userDetailService(){
        UserDetailService userDetailService = new UserDetailService();
        return userDetailService;
    }

    */
/**
 * 退出之后的处理
 *//*

    @Bean
    MyLogoutSuccessHandler myLogoutSuccessHandler(){
        MyLogoutSuccessHandler myLogoutSuccessHandler = new MyLogoutSuccessHandler();
        return myLogoutSuccessHandler;
    }

    */
/**
 * 自定义验证
 *//*

    @Bean
    MyAuthenticationProvider myAuthenticationProvider(){
        MyAuthenticationProvider myAuthenticationProvider = new MyAuthenticationProvider();
        return myAuthenticationProvider;
    }

    */
/**
 * session管理
 *//*

    @Bean
    MySessionRegistry mySessionRegistry(){
        MySessionRegistry mySessionRegistry = new MySessionRegistry();
        return  mySessionRegistry;
    }

    */
/**
 * 登录成功
 *//*

    @Bean
    MyLoginSuccessHandler myLoginSuccessHandler(){
        MyLoginSuccessHandler myLoginSuccessHandler = new MyLoginSuccessHandler();
        return  myLoginSuccessHandler;
    }

    */
/**
 * 自定义权限验证
 *//*

    @Bean
    AccessDecisionManagerService accessDecisionManagerService(){
        AccessDecisionManagerService accessDecisionManagerService = new AccessDecisionManagerService();
        return accessDecisionManagerService;
    }
}


*/
