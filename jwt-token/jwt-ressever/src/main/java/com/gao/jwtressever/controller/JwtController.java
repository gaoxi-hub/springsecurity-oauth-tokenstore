package com.gao.jwtressever.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: JwtController
 * Description:
 * date: 2020/7/17 17:54
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@RestController
public class JwtController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
