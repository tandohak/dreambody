package com.dreambody.model.userInit;

import com.dreambody.model.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : 이병덕
 * @description : 사용자가 초기에 정보 생성 시 선택하는 활동 범위
 * @date : 2020.06.21
 */

@Getter
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
    private float decimal;

    @Builder
    public Activity (String activity, float decimal) {
        this.activity = activity;
        this.decimal = decimal;
    }
}
