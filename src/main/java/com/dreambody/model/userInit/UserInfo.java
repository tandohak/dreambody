package com.dreambody.model.userInit;

import com.dreambody.model.BaseTimeEntity;
import com.dreambody.model.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.rmi.activation.ActivationID;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author : 이병덕
 * @description : 사용자가 초기에 입력한 성별, 활동성, 목표, 현재 몸무게, 목표 몸무, 키, 생일을 저장하는 Entity
 * @date : 2020.06.21
 */

@Slf4j
@Getter @Setter
@AllArgsConstructor
@Builder @NoArgsConstructor
@Table(name = "userInfos")
@Entity @ToString
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

    @Column(unique = true)
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public UserInfo(int currentWeight, int goalWeight, int height, String dateOfBirth, int dailyIntakeCalorie ,Gender gender, Goal goal, Activity activity, User user) {
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.dailyIntakeCalorie = dailyIntakeCalorie;
        this.gender = gender;
        this.goal = goal;
        this.activity = activity;
        this.user = user;
    }

    // 일일 칼로리 계산
    public int calculationDailyIntakeCalorie() {
        int currentYear = LocalDateTime.now().getYear();
        int userBirthYear = Integer.parseInt(dateOfBirth.substring(0,4));

        int age = currentYear - userBirthYear;

        log.info("계산식========");
        log.info("나이 : " + age);
        log.info("현재년도 : " + currentYear);
        log.info("사용자 생일 : " + userBirthYear);

        if (1 == gender.getId()) {
           dailyIntakeCalorie = (int) (66 + (13.7 * currentWeight) + (5 * height) - (6.5 * age));

           return dailyIntakeCalorie;
        }
        // 여자
        dailyIntakeCalorie = (int) (655 + (9.6 * currentWeight) + (1.8 * height) - (4.7 * age));

        return dailyIntakeCalorie;
    }
}