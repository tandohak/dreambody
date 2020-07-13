package com.dreambody.security.oauth2.user;

import com.dreambody.exception.OAuth2AuthenticationProcessingException;
import com.dreambody.model.AuthProvider;

import java.util.Map;

/**
 *   @author 홍윤표
 *   @description Oauth2UserInfo 생성하는 Factory 클래스 생성.
 *   @date 2020.07.11 18:54:33
 */

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
