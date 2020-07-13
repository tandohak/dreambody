package com.dreambody.security.oauth2.user;

import java.util.Map;

/**
 *   @author 홍윤표
 *   @description OAuth2 인증을 위한 Oauth2UserInfo 클래스 생성.
 *   @date 2020.07.11 18:55:28
 */
public abstract class OAuth2UserInfo {
    protected Map<String, Object> attributes;

    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getImageUrl();
}
