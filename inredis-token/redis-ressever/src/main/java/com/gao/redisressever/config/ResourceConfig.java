package com.gao.redisressever.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * ClassName: ResourceConfig
 * Description:
 * date: 2020/7/17 17:11
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }


    /**
     * resourceId如果和被分配的tokne不一致会拒绝
     * permitAll接口需要不带接口访问
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("redis").tokenStore(tokenStore()).authenticationEntryPoint(new MyAuthExceptionEntryPoint())
        .accessDeniedHandler(new MyAccessDeny());
    }

    @Autowired
    private MyFilter myFilter;

    @Autowired
    private GetUserInfoFilterConfig getUserInfoFilterConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
     //   http.apply(getUserInfoFilterConfig).and().authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().antMatchers("").permitAll();
        http.authorizeRequests().antMatchers("/hello2").denyAll();
        http.authorizeRequests().anyRequest().authenticated();

    }
}

