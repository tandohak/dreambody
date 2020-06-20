package com.dreambody.service.userInit;

import com.dreambody.controller.userInit.dto.ActivityResponseDto;
import com.dreambody.controller.userInit.dto.GoalResponseDto;
import com.dreambody.repository.userInit.ActivityRepository;
import com.dreambody.repository.userInit.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 이병덕
 * @description : Activity Entity Serivce
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    // 목표 조회
    @Transactional(readOnly = true)
    public List<ActivityResponseDto> findAll() {
        return activityRepository.findAll().stream()
                .map(ActivityResponseDto::new)
                .collect(Collectors.toList());
    }
}
