package com.dreambody.resolver;

import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.security.oauth2.user.UserPrincipal;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/*
 *   @author 홍윤표
 *   @description GraphQL. UserInfoResolver 생성.
 *   @date 2020.06.23 00:40:04
 */
@Component
@RequiredArgsConstructor
public class UserInfoResolver implements GraphQLQueryResolver {

    private final UserInfoRepository userInfoRepository;

    public UserInfo getUserInfo() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userInfoRepository.findByUser(User.builder().id(userPrincipal.getId()).build());
    }


}
