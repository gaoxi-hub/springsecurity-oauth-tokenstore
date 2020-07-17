package com.gao.momeryressever.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: MemoryController
 * Description:
 * date: 2020/7/17 15:12
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@RestController
public class MemoryController {
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
