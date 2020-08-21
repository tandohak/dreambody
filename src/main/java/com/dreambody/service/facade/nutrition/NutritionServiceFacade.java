package com.dreambody.service.facade.nutrition;

import com.dreambody.dbenum.EMealType;
import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.UserFoodMapping;
import com.dreambody.resolver.request.nutrition.FoodInfoRequest;
import com.dreambody.resolver.response.summary.FoodInfoSumResponse;
import com.dreambody.resolver.response.summary.UserFoodMappingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 이병덕
 * @description : 영양 관련 서비스
 * @date : 2020.07.11 22:29:36
 */

@Service
public interface NutritionServiceFacade {
    FoodInfoSumResponse saveUserFoodMapping(List<FoodInfoRequest> foodInfoRequest);
    List<UserFoodMappingResponse> getUserFoodMapping(User userId, FoodInfoRequest foodInfoRequest);
}
