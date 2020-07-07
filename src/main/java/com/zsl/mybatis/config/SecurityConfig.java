package com.zsl.mybatis.config;
/*

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*/
/**
 * @author : zsl
 * @date : Created in 2020/5/13 10:14 上午
 *//*

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true) //是否开启安全验证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    */
/**
     * 认证用户的来源【内存或者数据库】
     * @param auth
     * @throws Exception
     *//*

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中的情况
        auth.inMemoryAuthentication()
                .withUser("zsl")
                .password("{noop}123")
                .roles("ADMIN");
    }

    */
/**
     * 配置springsecurity相关信息
     * @param http
     * @throws Exception
     *//*

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //释放静态资源，指定资源拦截规则，指定自定义认证页面，指定退出认证配置，crsf配置
        http.authorizeRequests()
                .antMatchers("/login.jsp", "/failer.jsp", "/css/**", "/img/**", "/plugins/**").permitAll()
                .antMatchers("/**").hasAnyRole("USER", "ADMIN")
                .anyRequest()
                .authenticated() //任何通过认证的请求都可以访问
                .and()
                .formLogin()
                .loginPage("/login.jsp")
                .loginProcessingUrl("/login")
                .successForwardUrl("/index.jsp")
                .failureForwardUrl("/failer.jsp")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();//先关掉，方便测试
    }
}
*/
