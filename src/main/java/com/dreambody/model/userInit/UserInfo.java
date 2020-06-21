package com.dreambody.model.userInit;

import com.dreambody.model.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.rmi.activation.ActivationID;
import java.time.LocalDateTime;

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
    private String dateOfBirth;

    @Column(nullable = false)
    private int dailyIntakeCalorie;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;


    @Builder
    public UserInfo(int currentWeight, int goalWeight, int height, String dateOfBirth, int dailyIntakeCalorie ,Gender gender, Goal goal, Activity activity) {
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.dailyIntakeCalorie = dailyIntakeCalorie;
        this.gender = gender;
        this.goal = goal;
        this.activity = activity;
    }

    // 일일 칼로리 계산
    public int calculationDailyIntakeCalorie() {
        // 2020 하드 코딩 없애야 함.
        int age = 2020 - Integer.parseInt(dateOfBirth.substring(0,3));

        if ("남".equals(gender.getGender())) {
           dailyIntakeCalorie = (int) (66 + (13.7 * currentWeight) + (5 * height) - (6.5 * age));

           return dailyIntakeCalorie;
        }
        // 여자
        dailyIntakeCalorie = (int) (655 + (9.6 * currentWeight) + (1.8 * height) - (4.7 * age));

        return dailyIntakeCalorie;
    }
}
