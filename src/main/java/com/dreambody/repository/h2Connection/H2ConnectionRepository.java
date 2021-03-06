package com.dreambody.repository.h2Connection;

import com.dreambody.model.h2Connection.H2Connection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *   @author : 이병덕
 *   @description : H2 연동 테스트를 위한 엔티티
 *   @date : 2020.06.15
 */

public interface H2ConnectionRepository extends JpaRepository<H2Connection, Long> {
}