package com.dreambody.service.facade;

import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.resolver.response.summary.SummaryResponse;
import com.dreambody.security.oauth2.user.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

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

    @Override
    public SummaryResponse loadSummaryData() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User tempUser = User.builder().id(userPrincipal.getId()).build();
        UserInfo userInfo = userInfoRepository.findByUser(tempUser);

        log.info("UserInfo {}", userInfo);
        // 1. 목표 칼로리
        // 2. 목표 탄단지 계산.
        // 3. 섭취 칼로리.
        // 4. 섭취 탄단지 계산.

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
