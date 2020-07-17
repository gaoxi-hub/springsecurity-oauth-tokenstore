package com.gao.redisressever.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: RedisController
 * Description:
 * date: 2020/7/17 17:14
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@RestController
public class RedisController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

}
