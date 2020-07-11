package com.dreambody.security.oauth2.user;

import java.util.Map;

/**
 *   @author 홍윤표
 *   @description GoogleOAuth 인증을 위한 GoogleOAuth2UserInfo 클래스 생성.
 *   @date 2020.07.11 18:55:55
 */
public class GoogleOAuth2UserInfo extends OAuth2UserInfo {

    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("picture");
    }
}
