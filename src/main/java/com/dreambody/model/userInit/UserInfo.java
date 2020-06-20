package com.dreambody.model.userInit;

import com.dreambody.model.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.rmi.activation.ActivationID;

/**
 * @author : 이병덕
 * @description : 사용자가 초기에 입력한 성별, 활동성, 목표, 현재 몸무게, 목표 몸무, 키, 생일을 저장하는 Entity
 * @date : 2020.06.21
 */

@Getter
@NoArgsConstructor
@Table(name = "userInfos")
@Entity
public class UserInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int currentWeight;

    @Column(nullable = false)
    private int goalWeight;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;


//    @Builder
//    public UserInfo(String activity, float decimal) {
//        this.activity = activity;
//        this.decimal = decimal;
//    }
}
