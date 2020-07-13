package com.dreambody.service;

import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.resolver.request.userinfo.UserInfoRequest;
import com.dreambody.security.oauth2.user.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *   @author 홍윤표
 *   @description 유저 인포 서비스 생성.
 *   @date 2020.07.11 18:38:56
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public UserInfo saveUserInfo(UserInfoRequest userInfoRequest) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserInfo userInfo = userInfoRepository.findByUser(User.builder().id(userPrincipal.getId()).build());

        if (userInfo == null) {
            userInfo = userInfoRequest.toEntity();
            userInfo.setUser(User.builder().id(userPrincipal.getId()).build());

            return userInfoRepository.save(userInfo);
        }

        return userInfoRepository.save(userInfoRequest.toEntity(userInfo));
    }
}
