package com.gao.redisauthserver.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * ClassName: CustomTokenEnhancer
 * Description:
 * date: 2020/7/18 10:08
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        HashMap<String, Object> additionalInfo= new HashMap<>();
        additionalInfo.put("enhancer info","info");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
