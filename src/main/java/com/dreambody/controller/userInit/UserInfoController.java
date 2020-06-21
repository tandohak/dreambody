package com.dreambody.controller.userInit;


import com.dreambody.controller.userInit.dto.UserInfoSaveRequestDto;
import com.dreambody.service.userInit.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 이병덕
 * @decription : 회원정보 컨트롤러
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@RestController
public class UserInfoController {

    private final UserInfoService userInfoService;

    // 회원정보 저장
    @PostMapping("/userInfo")
    public Long save(@RequestBody UserInfoSaveRequestDto userInfoSaveRequestDto) {
        return userInfoService.save(userInfoSaveRequestDto);
    }
}
