package com.gao.momeryauthsever.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * ClassName: OauthController
 * Description:
 * date: 2020/7/21 14:19
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@RestController
public class OauthController {
    @RequestMapping("/oauth/user")
    public Principal getUser(Principal principal){
        return principal;
    }
}
