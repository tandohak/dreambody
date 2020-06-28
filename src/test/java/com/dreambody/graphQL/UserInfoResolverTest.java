package com.dreambody.graphQL;

import com.dreambody.model.AuthProvider;
import com.dreambody.model.User;
import com.dreambody.model.userInit.UserInfo;
import com.dreambody.repository.UserRepository;
import com.dreambody.repository.userInit.UserInfoRepository;
import com.dreambody.security.oauth2.user.UserPrincipal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 *   @author 홍윤표
 *   @description UserInfoResolver 테스트를 위한 클래스 생성.
 *   @date 2020.06.27 14:49:55
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserInfoResolverTest {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private GraphQLTestTemplate graphQLTestTemplate;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//
//        User mockUser = userRepository.findById(1L).orElse(null);
//
//        // SecurityContext Context Holder에 저장
//        SecurityContext securityContext = new SecurityContextImpl();
//        UserDetails userDetail = UserPrincipal.create(mockUser);
//        securityContext.setAuthentication(new TestingAuthenticationToken(userDetail,null, (List<GrantedAuthority>) userDetail.getAuthorities()));
//        SecurityContextHolder.setContext(securityContext);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhY2Nlc3NfdG9rZW4iLCJ1c2VyX2lkIjoiYVpWdkFaUXdiQURIdFVteHJXdGpNdz09IiwiZXhwIjoxNTkzNzA0NzEwLCJpYXQiOjE1OTI4NDA3MTB9.Q5rFjEaI5401ligQdE5znWWmejmiyqvt-UK7I3_pxoKf5VUZxc7uOU2FWYurXzmfEdKRRMX6RM2GLymjInkRGw");
//        graphQLTestTemplate.setHeaders(httpHeaders);
//
//    }
//
//    @Test
//    public void 유저정보_가져오기_테스트() throws IOException {
//        GraphQLResponse response = graphQLTestTemplate.postForResource("graphQl/getInfo/example.graphql");
//        assertNotNull(response);
//        assertTrue(response.isOk());
//        UserInfo userInfo = response.get("$.data.getUserInfo", UserInfo.class);
//        assertNotNull(userInfo);
//        assertEquals(1L, userInfo.getId());
//    }
//
//    @Test
//    public void 유저정보_저장_테스트() throws IOException {
//
//        ObjectNode variables = new ObjectMapper().createObjectNode();
//        ObjectNode innerVariables = new ObjectMapper().createObjectNode();
//        innerVariables.put("currentWeight", 80);
//        innerVariables.put("goalWeight", 70);
//        innerVariables.put("height", 180);
//        innerVariables.put("dateOfBirth", "1990-12-21");
//        innerVariables.put("gender", 1);
//        innerVariables.put("goal", 1);
//        innerVariables.put("activity", 1);
//        variables.put("userInfoWrapper" , innerVariables);
//
//        GraphQLResponse response = graphQLTestTemplate.perform("graphQl/infoSave/example.graphql", variables);
//
//        assertNotNull(response);
//        assertTrue(response.isOk());
//        assertNotNull(response.get("$.data.saveUserInfo", UserInfo.class));
//    }

}


