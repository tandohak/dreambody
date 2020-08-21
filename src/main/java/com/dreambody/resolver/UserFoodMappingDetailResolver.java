package com.dreambody.resolver;

import com.dreambody.dbenum.EMealType;
import com.dreambody.model.User;
import com.dreambody.model.foodInfo.UserFoodMapping;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.foodInfo.UserFoodMappingRepository;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.resolver.request.nutrition.FoodInfoRequest;
import com.dreambody.resolver.response.summary.UserFoodMappingResponse;
import com.dreambody.security.oauth2.user.UserPrincipal;
import com.dreambody.service.facade.nutrition.NutritionServiceFacade;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 이병덕
 * @description : 영양 정보 상세 페이지, 아침, 점심, 저녁, 간식
 * @date : 2020.07.12 04:58:28
 */

@Component
@RequiredArgsConstructor
public class UserFoodMappingDetailResolver implements GraphQLQueryResolver {

    private final NutritionServiceFacade nutritionServiceFacade;

    @GraphQLQuery(name = "userFoodMapping")
    public List<UserFoodMappingResponse> getUserFoodMapping(FoodInfoRequest foodInfoRequest) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return nutritionServiceFacade.getUserFoodMapping(User.builder().id(userPrincipal.getId()).build(), foodInfoRequest);
    }
}
