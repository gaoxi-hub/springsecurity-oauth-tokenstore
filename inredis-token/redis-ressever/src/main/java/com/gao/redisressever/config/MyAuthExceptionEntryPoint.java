package com.gao.redisressever.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: MyAuthExceptionEntryPoint
 * Description: 不放token会走这个类
 *              无效token会走这个类
 *              过期token会走这个类
 * date: 2020/7/20 14:20
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Component
public class MyAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.getWriter().println("MyAuthExceptionEntryPoint");
    }
}
