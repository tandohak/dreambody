package com.dreambody.repository.h2Connection;

import com.dreambody.model.h2Connection.H2Connection;
import com.dreambody.repository.h2Connection.H2ConnectionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 *   @author : 이병덕
 *   @description : H2 연동 테스트를 위한 엔티티
 *   @date : 2020.06.15
 */

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