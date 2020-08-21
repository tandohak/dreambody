package com.dreambody.service.water;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.WaterInfo;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.repository.water.WaterInfoRepository;
import com.dreambody.resolver.request.water.WaterInfoRequest;
import com.dreambody.security.oauth2.user.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 이병덕
 * @description : 물 저장하는 서비스
 * @date : 2020.08.20 23:08:04
 */

@RequiredArgsConstructor
@Component("waterInfoService")
public class WaterInfoService {

    private final WaterInfoRepository waterInfoRepository;
    private final UserInfoRepository userInfoRepository;

    @Transactional
    public WaterInfo saveWaterInfo(WaterInfoRequest waterInfoRequest) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User tempUser = User.builder().id(userPrincipal.getId()).build();
        UserInfo userInfo = userInfoRepository.findByUser(tempUser);

        WaterInfo waterInfo = waterInfoRepository.findByUserIdAndRegistrationDate(userInfo.getId(), waterInfoRequest.getRegistrationDate());

        if (waterInfo == null) {
            return waterInfoRepository.save(waterInfoRequest.toEntity(userInfo.getId()));
        }

        waterInfo.updateWater(waterInfoRequest.getAmountWater());

        return waterInfo;
    }

    public WaterInfo getWaterInfo(WaterInfoRequest waterInfoRequest) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User tempUser = User.builder().id(userPrincipal.getId()).build();
        UserInfo userInfo = userInfoRepository.findByUser(tempUser);

        return waterInfoRepository.findByUserIdAndRegistrationDate(userInfo.getId(), waterInfoRequest.getRegistrationDate());
    }
}
