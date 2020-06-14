package com.dreambody.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/* H2 연동 테스트를 위한 엔티티
 * developer : 이병덕
 * 잘 돌아가면 파일 제거 해주세요
 * */

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2ConnectionRepositoryTest {

    @Autowired
    private H2ConnectionRepository h2ConnectionRepository;

    private String name = "이병덕";

    @Before
    public void setUp() {
        H2Connection h2Connection = H2Connection.builder().name(name).build();
        h2ConnectionRepository.save(h2Connection);
    }

    @Test
    public void H2DB에서_모든_값을_가져온다() {
        List<H2Connection> h2Connections = h2ConnectionRepository.findAll();

        assertThat(h2Connections.get(0).getName()).isEqualTo(name);
    }
}