package com.dreambody.model.userInit;

import com.dreambody.model.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author : 이병덕
 * @description : 사용자가 초기에 정보 생성 시 선택하는 활동 범위
 * @date : 2020.06.21
 */

@Getter @Setter
@AllArgsConstructor @Builder
@NoArgsConstructor
@Table(name = "activities", uniqueConstraints = {
        @UniqueConstraint(columnNames = "activity")
})
@Entity
public class Activity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String activity;

    @Column(nullable = false)
    private float volume;
}
