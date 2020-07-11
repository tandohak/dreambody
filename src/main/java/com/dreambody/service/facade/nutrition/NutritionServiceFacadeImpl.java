package com.dreambody.service.facade.nutrition;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.UserFoodMapping;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.foodInfo.FoodInfoRepository;
import com.dreambody.repository.foodInfo.UserFoodMappingRepository;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.resolver.request.nutrition.FoodInfoRequest;
import com.dreambody.resolver.response.summary.UserFoodMappingResponse;
import com.dreambody.security.oauth2.user.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 이병덕
 * @description : 영양관련 구현 서비스
 * @date : 2020.07.11 22:30:06
 */

@Slf4j
@Component("nutritionService")
@RequiredArgsConstructor
public class NutritionServiceFacadeImpl implements NutritionServiceFacade {

    private final FoodInfoRepository foodInfoRepository;
    private final UserFoodMappingRepository userFoodMappingRepository;
    private final UserInfoRepository userInfoRepository;

    @Override
    public Long saveUserFoodMapping(FoodInfoRequest foodInfoRequest) {
        return getFoodInfo(foodInfoRequest);
    }

    private Long getFoodInfo(FoodInfoRequest foodInfoRequest) {
        FoodInfo foodInfo = foodInfoRepository.findByCode(foodInfoRequest.getCode());
        Long id = null;

        if(foodInfo == null) {
            id = foodInfoRepository.save(foodInfoRequest.toFoodInfoEntity()).getId();
            return generateUserFoodMappingRequest(foodInfoRequest, id);
        }

        id = foodInfo.getId();

        return generateUserFoodMappingRequest(foodInfoRequest, id);
    }

    private Long generateUserFoodMappingRequest(FoodInfoRequest foodInfoRequest, Long foodInfoId) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User tempUser = User.builder().id(userPrincipal.getId()).build();
        UserInfo userInfo = userInfoRepository.findByUser(tempUser);

        foodInfoRequest.generateUserFoodMappingRequest(foodInfoId, userInfo.getId());

        return userFoodMappingRepository.save(foodInfoRequest.toUserFoodMappingEntity()).getId();
    }

//    @Override
//    public List<UserFoodMapping> getUserFoodMappingDetail(User user, Long mealTypeId) {
//        return userFoodMappingRepository.findByUserIdAndMealTypeId(user.getId(), mealTypeId);
//    }

    @Override
    public List<UserFoodMapping> getUserFoodMappingDetail() {
        return userFoodMappingRepository.findAll();
    }
}
