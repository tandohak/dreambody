package com.dreambody.resolver;

import com.dreambody.resolver.response.foodInfo.MealTypeResponse;
import com.dreambody.service.foodInfo.MealTypeService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 이병덕
 * @description : 식사타입 리졸버
 * @date : 2020.07.11 19:50:01
 */

@Component
@RequiredArgsConstructor
public class MealTypeResolver implements GraphQLQueryResolver {

    private final MealTypeService mealTypeService;

    @GraphQLQuery(name = "mealtypes")
    public List<MealTypeResponse> getMealTypes() {
        return mealTypeService.load();
    }
}
