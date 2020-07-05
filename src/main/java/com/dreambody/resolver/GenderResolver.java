package com.dreambody.resolver;

import com.dreambody.controller.userInit.dto.GenderResponseDto;
import com.dreambody.model.User;
import com.dreambody.model.userInit.Gender;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.userInit.GenderRepository;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.security.oauth2.user.UserPrincipal;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 이병덕
 * @description GraphQL. GenderResolver 생성.
 * @date 2020.07.05
 */

@Component
@RequiredArgsConstructor
public class GenderResolver implements GraphQLQueryResolver {

    private final GenderRepository genderRepository;

    public List<Gender> getGender() {
        return genderRepository.findAll();
    }


}
