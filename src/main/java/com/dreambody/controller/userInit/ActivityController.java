package com.dreambody.controller.userInit;


import com.dreambody.controller.userInit.dto.ActivityResponseDto;
import com.dreambody.controller.userInit.dto.GoalResponseDto;
import com.dreambody.service.userInit.ActivityService;
import com.dreambody.service.userInit.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 이병덕
 * @decription : 활동성 조회 컨트롤러
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@RestController
public class ActivityController {

    private final ActivityService activityService;

    // 목표 조회
    @GetMapping("/activity")
    public List<ActivityResponseDto> findAll() {
        return activityService.findAll();
    }
}
