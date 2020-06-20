package com.dreambody.model;

import com.dreambody.model.h2Connection.H2Connection;
import com.dreambody.model.h2Connection.H2ConnectionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
 *   @auth : 이병덕
 *   @description : BaseTimeEntity 테스트 코드
 *   @date : 2020.06.15
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTimeEntityTest {

    @Autowired
    H2ConnectionRepository h2ConnectionRepository;

    @Before
    public void setUp() {
        h2ConnectionRepository.deleteAll();
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.now();

        h2ConnectionRepository.save(H2Connection.builder().name("이병덕").build());

        // when
        List<H2Connection> h2Connections = h2ConnectionRepository.findAll();

        // then
        H2Connection h2Connection = h2Connections.get(0);

        assertThat(h2Connection.getCreateDate()).isAfter(now);
        assertThat(h2Connection.getModifiedDate()).isAfter(now);
    }
}