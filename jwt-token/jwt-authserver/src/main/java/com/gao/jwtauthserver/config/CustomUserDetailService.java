package com.gao.jwtauthserver.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * ClassName: CustomUserDetail
 * Description:
 * date: 2020/7/17 15:01
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return new User("gaoxi",passwordEncoder.encode("123456"),true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
    }
}
