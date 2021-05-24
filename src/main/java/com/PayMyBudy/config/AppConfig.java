package com.PayMyBudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/**","js/*").authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/signin").permitAll()
                .defaultSuccessUrl("/paymybuddy", true)
                .and()
                .httpBasic()
                .and()
                .rememberMe();



    }
        /*   http
                   .csrf().disable()
                .authorizeRequests()
                .antMatchers("/signin.css","/index.css","/contact.css","js/*","/signin","/register","login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("login")
                .defaultSuccessUrl("/paymybuddy", true)
                .and()
                .httpBasic()
                .and()
                .rememberMe();
*/


}