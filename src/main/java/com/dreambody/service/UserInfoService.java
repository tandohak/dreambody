package com.dreambody.service;

import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.UserRepository;
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
    private final UserRepository userRepository;

    public UserInfo saveUserInfo(UserInfoRequest userInfoRequest) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findById(userPrincipal.getId()).orElse(null);

        UserInfo userInfo = userInfoRepository.findByUser(user);

        if (userInfo == null) {
            userInfo = userInfoRequest.toEntity();
            userInfo.setUser(user);
            user.setAnsweredQuestion(true);
            userRepository.save(user);
            return userInfoRepository.save(userInfo);
        }

        return userInfoRepository.save(userInfoRequest.toEntity(userInfo));
    }
}
