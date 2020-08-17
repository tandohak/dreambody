package com.dreambody.resolver;

import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.resolver.request.nutrition.FoodInfoRequest;
import com.dreambody.resolver.response.summary.FoodInfoSumResponse;
import com.dreambody.service.facade.nutrition.NutritionServiceFacade;
import graphql.kickstart.tools.GraphQLMutationResolver;
import io.leangen.graphql.annotations.GraphQLMutation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 이병덕
 * @description : 아침, 점심, 저녁, 간식 저장하는 리졸버
 * @date : 2020.07.11 22:26:07
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFoodMappingMutationResolver implements GraphQLMutationResolver {
    private final NutritionServiceFacade nutritionServiceFacade;

    @GraphQLMutation(name = "saveUserFoodMapping")
    public FoodInfoSumResponse saveUserFoodMapping(List<FoodInfoRequest> foodInfoRequest) {
        return nutritionServiceFacade.saveUserFoodMapping(foodInfoRequest);
    }
}
