package com.dreambody.resolver;

import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.resolver.request.userinfo.RequestUserInfo;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.security.oauth2.user.UserPrincipal;
import graphql.kickstart.tools.GraphQLMutationResolver;
import io.leangen.graphql.annotations.GraphQLMutation;
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

    @GraphQLMutation(name = "saveUserInfo")
    public UserInfo saveUserInfo(RequestUserInfo userInfoWrapper) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserInfo userInfo = userInfoRepository.findByUser(User.builder().id(userPrincipal.getId()).build());

        // 컨트롤러 개념인 wrapper에서 할 일이 아닌 것 같아용.
        // 개선하상
        // 1. service로 로직 빼기
        if (userInfo == null) {
            userInfo = userInfoWrapper.toEntity();
            userInfo.setUser(User.builder().id(userPrincipal.getId()).build());

            return userInfoRepository.save(userInfo);
        }

        return userInfoRepository.save(userInfoWrapper.toEntity(userInfo));
    }
}
