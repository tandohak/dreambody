package com.dreambody.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/* H2 연동 테스트를 위한 엔티티
 * developer : 이병덕
 * 잘 돌아가면 파일 제거 해주세요
 * */

public interface H2ConnectionRepository extends JpaRepository<H2Connection, Long> {
}