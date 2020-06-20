package com.dreambody.model.userInit;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : 이병덕
 * @description : 사용자가 초기에 정보 생성 시 선택하는 목표
 * 데이터성이 아닌, 단순히 사용자의 목표가 무엇인지 명시적으로 보여주기 위함
 * @date : 2020.06.21
 */

@Getter
@NoArgsConstructor
@Table(name = "goals", uniqueConstraints = {
        @UniqueConstraint(columnNames = "goal")
})
@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String goal;

    @Builder
    public Goal (String goal) {
        this.goal = goal;
    }
}
