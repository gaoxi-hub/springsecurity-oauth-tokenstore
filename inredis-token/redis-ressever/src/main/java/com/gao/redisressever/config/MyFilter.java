package com.gao.redisressever.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: MyFilter
 * Description:
 * date: 2020/7/20 16:53
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Component
public class MyFilter extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("hello");
        filterChain.doFilter(request,response);
 /*      OAuth2Authentication authentication =(OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Authentication userAuthentication = authentication.getUserAuthentication();
        User principal1 =(User) userAuthentication.getPrincipal();
        Object details1 = userAuthentication.getDetails();
        CustomHttpServletRequest customHttpServletRequest=new CustomHttpServletRequest(request);
        customHttpServletRequest.addHeader("userId",principal1.getUsername());

        filterChain.doFilter(customHttpServletRequest, response);*/
    }
}
