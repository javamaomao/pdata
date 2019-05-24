package com.jifenkeji.pdata.config

import com.jifenkeji.pdata.service.imp.CustomAdminDetailsService
import com.jifenkeji.pdata.utils.MyPasswordEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Bean
    internal fun customAdminService(): UserDetailsService {
        return CustomAdminDetailsService()
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(customAdminService())
                .passwordEncoder(MyPasswordEncoder())
        //BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(web: WebSecurity?) {
        web ?: return
        web.ignoring()
                .antMatchers("/resources/**")
        //super.configure(web)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .csrf() //跨站
                .disable()  //关闭跨站检测
                .authorizeRequests()    //验证策略
                .antMatchers("/css/**","/image/*","/js/*").permitAll()
                .antMatchers("/admin/**").permitAll() // #hasAnyRole("ADMIN")
                .antMatchers("/**").permitAll()    //需要验证authenticated
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")// 设置登录页面
                .loginProcessingUrl("/login") // 自定义的登录接口
                .defaultSuccessUrl("/")
                .failureUrl("/loginFailure")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .permitAll()
                .and()
                .headers().frameOptions().disable()
    }
}