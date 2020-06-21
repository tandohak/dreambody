package com.dreambody.controller.userInit;


import com.dreambody.controller.userInit.dto.UserInfoSaveRequestDto;
import com.dreambody.model.User;
import com.dreambody.security.CurrentUser;
import com.dreambody.security.oauth2.user.UserPrincipal;
import com.dreambody.service.userInit.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 이병덕
 * @decription : 회원정보 컨트롤러
 * @date : 2020.06.21
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserInfoController {

    private final UserInfoService userInfoService;

    // 회원정보 저장
    @PostMapping("/userInfo")
    public Long save(@CurrentUser UserPrincipal userPrincipal, @RequestBody UserInfoSaveRequestDto userInfoSaveRequestDto) {
        userInfoSaveRequestDto.setUser(User.builder().id(userPrincipal.getId()).build());
        return userInfoService.save(userInfoSaveRequestDto);
    }

    @GetMapping("/userInfo")
    public ResponseEntity load(@CurrentUser UserPrincipal userPrincipal) {
        return ResponseEntity.ok(userInfoService.findByUserId(userPrincipal.getId()));
    }
}
