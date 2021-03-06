package com.dreambody.service.facade.nutrition;

import com.dreambody.dbenum.EMealType;
import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.UserFoodMapping;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.foodInfo.FoodInfoRepository;
import com.dreambody.repository.foodInfo.UserFoodMappingRepository;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.resolver.request.nutrition.FoodInfoRequest;
import com.dreambody.resolver.response.summary.FoodInfoSumResponse;
import com.dreambody.resolver.response.summary.UserFoodMappingResponse;
import com.dreambody.security.oauth2.user.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public FoodInfoSumResponse saveUserFoodMapping(List<FoodInfoRequest> foodInfoRequests) {
        return getFoodInfo(foodInfoRequests);
    }

    private FoodInfoSumResponse getFoodInfo(List<FoodInfoRequest> foodInfoRequests) {
        Long id = null;

        for (FoodInfoRequest foodInfoRequest : foodInfoRequests) {
            FoodInfo foodInfo = foodInfoRepository.findByCode(foodInfoRequest.getCode());

            if (foodInfo == null) {
                id = foodInfoRepository.save(foodInfoRequest.toFoodInfoEntity()).getId();
            } else {
                id = foodInfo.getId();
            }

            generateUserFoodMappingRequest(foodInfoRequest, id);
        }

        return FoodInfoSumResponse.builder().foodInfoRequests(foodInfoRequests).build();
    }

    private void generateUserFoodMappingRequest(FoodInfoRequest foodInfoRequest, Long foodInfoId) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User tempUser = User.builder().id(userPrincipal.getId()).build();
        UserInfo userInfo = userInfoRepository.findByUser(tempUser);

        foodInfoRequest.generateUserFoodMappingRequest(foodInfoId, userInfo.getId());

        userFoodMappingRepository.save(foodInfoRequest.toUserFoodMappingEntity());
    }

    @Override
    public List<UserFoodMappingResponse> getUserFoodMapping(User user, FoodInfoRequest foodInfoRequest) {
        if(foodInfoRequest.getMealType() == null) {
            return userFoodMappingRepository.findByUserIdAndRegistrationDate(user.getId(), foodInfoRequest.getRegistrationDate())
                    .stream()
                    .map(UserFoodMappingResponse::new)
                    .collect(Collectors.toList());
        }

        return userFoodMappingRepository.findByUserIdAndMealTypeAndRegistrationDate(user.getId(), foodInfoRequest.getMealType(), foodInfoRequest.getRegistrationDate())
                .stream()
                .map(UserFoodMappingResponse::new)
                .collect(Collectors.toList());
    }
}
