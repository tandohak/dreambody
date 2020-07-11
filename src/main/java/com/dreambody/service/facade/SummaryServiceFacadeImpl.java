package com.dreambody.service.facade;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.UserFoodMapping;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.foodInfo.UserFoodMappingRepository;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.resolver.response.summary.SummaryResponse;
import com.dreambody.security.oauth2.user.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
    public SummaryResponse loadSummaryData(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate registrationDate) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User tempUser = User.builder().id(userPrincipal.getId()).build();
        UserInfo userInfo = userInfoRepository.findByUser(tempUser);

        log.info("UserInfo {}", userInfo);
        // 1. 목표 칼로리
        // 2. 목표 탄단지 계산.
        // 3. 섭취 칼로리.
        // 4. 섭취 탄단지 계산.
        List<UserFoodMapping> userFoodMappings = userFoodMappingRepository.findAllByUserIdxAndRegistrationDate(userInfo.getId(), registrationDate);

        Integer intakeCalorie = 0;
        Integer intakeCarbohydrate = 0;
        Integer intakeFat = 0;
        Integer intakeProtein = 0;

        userFoodMappings.forEach( v -> {
            FoodInfo foodInfo = v.getFoodInfo();

        });

        return SummaryResponse.builder()
                .goalCalorie(0)
                .goalCarbohydrate(0)
                .goalFat(0)
                .goalProtein(0)
                .intakeCalorie(userInfo.calculationDailyIntakeCalorie())
                .intakeCarbohydrate(0)
                .intakeFat(0)
                .intakeProtein(0)
                .build();
    }
}
