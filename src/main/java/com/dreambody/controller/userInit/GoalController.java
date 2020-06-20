package com.dreambody.controller.userInit;


import com.dreambody.controller.userInit.dto.GenderResponseDto;
import com.dreambody.controller.userInit.dto.GoalResponseDto;
import com.dreambody.service.userInit.GenderService;
import com.dreambody.service.userInit.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 이병덕
 * @decription : 목표조회 컨트롤러
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@RestController
public class GoalController {

    private final GoalService goalService;

    // 목표 조회
    @GetMapping("/gender")
    public List<GoalResponseDto> findAll() {
        return goalService.findAll();
    }
}
