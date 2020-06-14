package com.dreambody.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* H2 연동 테스트를 위한 엔티티
 * developer : 이병덕
 * 잘 돌아가면 파일 제거 해주세요
 * */

@Getter
@NoArgsConstructor
@Entity
public class H2Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Builder
    public H2Connection(String name) {
        this.name = name;
    }
}
