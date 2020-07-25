package com.gao.redisressever.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * ClassName: GetUserInfoFilterConfig
 * Description:
 * date: 2020/7/20 16:59
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Component
public class GetUserInfoFilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private MyFilter myFilter;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        builder.addFilterAfter(myFilter, OAuth2AuthenticationProcessingFilter.class);
    }
}
