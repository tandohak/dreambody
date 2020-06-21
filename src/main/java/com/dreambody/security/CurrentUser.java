package com.dreambody.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/*
 *   @author 홍윤표
 *   @description 컨트롤러에서 인증된 UserPrincipal 주입 받기 위해 생성.
 *   @date 2020.06.16 17:05:09
 */

// @AuthenticationPrincipal 애노테이션을 사용하면 UserDetailsService에서 Return한 객체 를 파라메터로 직접 받아 사용할 수 있다.
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {
}
