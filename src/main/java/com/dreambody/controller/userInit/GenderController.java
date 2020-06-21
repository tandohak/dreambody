package com.dreambody.controller.userInit;


import com.dreambody.controller.userInit.dto.GenderResponseDto;
import com.dreambody.service.userInit.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 이병덕
 * @decription : 성별조회 컨트롤러
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@RestController
public class GenderController {

    private final GenderService genderService;

    // 성별 조회
    @GetMapping("/gender")
    public List<GenderResponseDto> findAll() {
        return genderService.findAll();
    }
}
