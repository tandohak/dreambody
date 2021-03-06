package com.dreambody.service.facade.summary;

import com.dreambody.dbenum.EMealType;
import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.UserFoodMapping;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.foodInfo.UserFoodMappingRepository;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.resolver.request.summary.RequestSummary;
import com.dreambody.resolver.response.summary.ResponseGoal;
import com.dreambody.resolver.response.summary.ResponseIntake;
import com.dreambody.resolver.response.summary.ResponseSummary;
import com.dreambody.security.oauth2.user.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 홍윤표
 * @description 요약 데이터를 위한 서비스 생성.
 * @date 2020.07.11 14:12:16
 */

@Slf4j
@Component("summaryService")
@RequiredArgsConstructor
public class SummaryServiceFacadeImpl implements SummaryServiceFacade {

    private final UserInfoRepository userInfoRepository;
    private final UserFoodMappingRepository userFoodMappingRepository;

    @Override
    public ResponseSummary loadSummaryData(RequestSummary requestSummary) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User tempUser = User.builder().id(userPrincipal.getId()).build();
        UserInfo userInfo = userInfoRepository.findByUser(tempUser);

        if (requestSummary.getRegistrationDate() == null) {
            requestSummary.setRegistrationDate(LocalDate.now());
        }

        Integer goalCalorie = userInfo.calculationDailyIntakeCalorie();
        Integer goalCarbohydrate = userInfo.calculationDailyIntakeCarbohydrate();
        Integer goalFat = userInfo.calculationDailyIntakeFat();
        Integer goalProtein = userInfo.calculationDailyIntakeProtein();

        List<UserFoodMapping> userFoodMappings = new ArrayList<>();

        // 식사 타입이 있을 경우.
        if (requestSummary.getMealType() != null) {
            EMealType mealType1 = requestSummary.getMealType();
            userFoodMappings = userFoodMappingRepository.findAllByUserAndRegistrationDateAndMealType(tempUser, requestSummary.getRegistrationDate(), mealType1);

            goalCalorie = userInfo.calculationDailyIntakeCalorie(requestSummary.getMealType());
            goalCarbohydrate = userInfo.calculationDailyIntakeCarbohydrate(requestSummary.getMealType());
            goalFat = userInfo.calculationDailyIntakeFat(requestSummary.getMealType());
            goalProtein = userInfo.calculationDailyIntakeProtein(requestSummary.getMealType());
        }

        // 식사 타입이 없을 경우.
        if (requestSummary.getMealType() == null) {
            userFoodMappings = userFoodMappingRepository.findAllByUserAndRegistrationDate(tempUser, requestSummary.getRegistrationDate());

        }

        Float intakeCalorie = 0f;
        Float intakeCarbohydrate = 0f;
        Float intakeFat = 0f;
        Float intakeProtein = 0f;

        for (UserFoodMapping userFoodMapping : userFoodMappings) {
            FoodInfo foodInfo = userFoodMapping.getFoodInfo();
            intakeCalorie += foodInfo.getCalorie() * userFoodMapping.getQuantity();
            intakeCarbohydrate += foodInfo.getCarbohydrate() * userFoodMapping.getQuantity();
            intakeFat += foodInfo.getFat().intValue() * userFoodMapping.getQuantity();
            intakeProtein += foodInfo.getProtein() * userFoodMapping.getQuantity();
        }

        ResponseGoal goal = ResponseGoal.builder()
                .calorie(goalCalorie)
                .carbohydrate(goalCarbohydrate)
                .fat(goalFat)
                .protein(goalProtein)
                .build();


        ResponseIntake intake = ResponseIntake.builder()
                .calorie(intakeCalorie.intValue())
                .carbohydrate(intakeCarbohydrate.intValue())
                .fat(intakeFat.intValue())
                .protein(intakeProtein.intValue())
                .build();

        return ResponseSummary.builder()
                .goal(goal)
                .intake(intake)
                .build();
    }


}
