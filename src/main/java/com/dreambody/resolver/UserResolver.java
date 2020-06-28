package com.dreambody.resolver;

import com.dreambody.model.User;
import com.dreambody.repository.UserRepository;
import com.dreambody.security.oauth2.user.UserPrincipal;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/*
 *   @author 홍윤표
 *   @description 유저 객체 가져오는 GraphQL. UserResolver 생성.
 *   @date 2020.06.23
 */
@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public User getUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findById(userPrincipal.getId()).get();
    }
}
