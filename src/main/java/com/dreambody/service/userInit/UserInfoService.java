package com.dreambody.service.userInit;

import com.dreambody.controller.userInit.dto.UserInfoSaveRequestDto;
import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.userInit.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 이병덕
 * @description : UserInfo Entity Serivce
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@Service
@Slf4j
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    //  회원 정보 최초 저장
    @Transactional
    public Long save(UserInfoSaveRequestDto userInfoSaveRequestDto) {
        UserInfo userInfo = userInfoSaveRequestDto.toEntity();
        userInfo.calculationDailyIntakeCalorie(); // 일일 칼로리 계산
        log.info("userInfo {}", userInfo);
        return userInfoRepository.save(userInfo).getId();
    }

    @Transactional(readOnly = true)
    public UserInfo findByUserId(Long id) {
        return userInfoRepository.findByUser(User.builder().id(id).build());
    }
}
