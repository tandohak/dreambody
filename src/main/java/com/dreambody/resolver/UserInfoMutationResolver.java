package com.dreambody.resolver;

import com.dreambody.model.userInit.UserInfo;
import com.dreambody.resolver.request.userinfo.RequestUserInfo;
import com.dreambody.service.UserInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import io.leangen.graphql.annotations.GraphQLMutation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final UserInfoService userInfoService;

    @GraphQLMutation(name = "saveUserInfo")
    public UserInfo saveUserInfo(RequestUserInfo requestUserInfo) {
        return userInfoService.saveUserInf(requestUserInfo);
    }
}
