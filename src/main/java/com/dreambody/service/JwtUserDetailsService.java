package com.dreambody.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
 *   @author 홍윤표
 *   @description 유저인증을 위한 UserDetailService.
 *   @date 2020.06.16 10:29:47
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO : DB 연동.
        return new User("foo", "foo", new ArrayList<>());
    }
}
