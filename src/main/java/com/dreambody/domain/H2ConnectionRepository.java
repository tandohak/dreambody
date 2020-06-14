package com.dreambody.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/* description : H2 연동 테스트를 위한 엔티티
 * auth : 이병덕
 * */

public interface H2ConnectionRepository extends JpaRepository<H2Connection, Long> {
}