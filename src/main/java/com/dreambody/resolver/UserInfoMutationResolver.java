package com.dreambody.resolver;

import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.model.wrapper.UserInfoWrapper;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.security.oauth2.user.UserPrincipal;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/*
 *   @author 홍윤표
 *   @description 유저정보 저장을 위한 Mutation 리졸버 생성.
 *   @date 2020.06.23
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserInfoMutationResolver implements GraphQLMutationResolver {
    private final UserInfoRepository userInfoRepository;

    public UserInfo saveUserInfo(UserInfoWrapper userInfoWrapper) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserInfo userInfo = userInfoRepository.findByUser(User.builder().id(userPrincipal.getId()).build());

        if (userInfo == null) {
            userInfo = userInfoWrapper.toEntity();
            userInfo.setUser(User.builder().id(userPrincipal.getId()).build());
        } else {
            userInfo = userInfoWrapper.toEntity(userInfo);
        }

        return userInfoRepository.save(userInfo);
    }
}
