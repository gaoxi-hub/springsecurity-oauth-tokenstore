package com.gao.redisressever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

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
    /*    System.out.println(ee);
        System.out.println(userId);*/ return "hello";
    }


    @GetMapping("hello2")
    public String hello2(){
        return "hello2";
    }

    @GetMapping("hello3")
    public String hello3(){
        return "hello3";
    }

    @GetMapping("hello4")
    public String hello4(){
        return "hello4";
    }


    @Autowired
    private TokenStore tokenStore;
    @GetMapping("scanAccessToken")
    public void ScanAccessToken(String accessToken){

        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
        OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(oAuth2AccessToken);
        Collection<OAuth2AccessToken> tokensByClientIdAndUserName = tokenStore.findTokensByClientIdAndUserName("yurun", "gaoxi");
        for(OAuth2AccessToken token:tokensByClientIdAndUserName){
            System.out.println(token);
            OAuth2RefreshToken refreshToken = token.getRefreshToken();
        }
        Collection<OAuth2AccessToken> tokensByClientIdAndUserName1 = tokenStore.findTokensByClientIdAndUserName("yurun2", "gaoxi");

        Collection<OAuth2AccessToken> tokensByClientIdAndUserName2 = tokenStore.findTokensByClientIdAndUserName("yurun", "gaoxi1");
        return;
    }

}
