package com.demo.mp.service.impl;

import com.demo.mp.entity.User;
import com.demo.mp.entity.UserOAuthEntity;
import com.demo.mp.extVO.CustomUser;
import com.demo.mp.service.IUserOAuth2Service;
import com.demo.mp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class CustomDetailsService implements UserDetailsService {

    @Autowired
    IUserOAuth2Service userOAuth2Service;

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
        grantedAuthoritiesList.add(grantedAuthority);
        UserOAuthEntity userOAuthEntity = null;
        try {
            List<User> userList = userService.lambdaQuery("钱大妈A0");
            userOAuthEntity = userOAuth2Service.getUserOAuth2(username);
            CustomUser customUser = new CustomUser(userOAuthEntity,grantedAuthoritiesList);
            return customUser;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }
}
