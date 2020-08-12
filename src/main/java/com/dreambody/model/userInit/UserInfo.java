package com.dreambody.model.userInit;

import com.dreambody.dbenum.EActivity;
import com.dreambody.dbenum.EGender;
import com.dreambody.dbenum.EGoal;
import com.dreambody.dbenum.EMealType;
import com.dreambody.model.BaseTimeEntity;
import com.dreambody.model.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Min(value = 1)
    @Max(value = 999)
    @Column(nullable = false)
    private int currentWeight;

    @Min(value = 1)
    @Max(value = 999)
    @Column(nullable = false)
    private int goalWeight;

    @Min(value = 1)
    @Max(value = 999)
    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private String dateOfBirth;

    @Min(value = 1)
    @Max(value = 99999)
    @Column(nullable = false)
    private int dailyIntakeCalorie;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(unique = true)
    private LocalDate registrationDate;

    @Enumerated(value = EnumType.STRING)
    private EGender genderType;

    @Enumerated(value = EnumType.STRING)
    private EGoal goalType;

    @Enumerated(value = EnumType.STRING)
    private EActivity activityType;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 일일 칼로리 계산
    public int calculationDailyIntakeCalorie() {
        int currentYear = LocalDateTime.now().getYear();
        int userBirthYear = Integer.parseInt(dateOfBirth.substring(0,4));

        int age = currentYear - userBirthYear;

        log.info("계산식========");
        log.info("나이 : " + age);
        log.info("현재년도 : " + currentYear);
        log.info("사용자 생일 : " + userBirthYear);
        log.info("성별 : " + genderType.name());

        if("MALE".equals(genderType.name())) {
            log.info("MALE");
            dailyIntakeCalorie = (int) (66 + (13.7 * goalWeight) + (5 * height) - (6.5 * age));
        } else if("FEMALE".equals(genderType.name())) {
            log.info("FEMALE");
            dailyIntakeCalorie = (int) (655 + (9.6 * goalWeight) + (1.8 * height) - (4.7 * age));
        }

        log.info("dailyIntakeCalorie : " + dailyIntakeCalorie);
        // added by 홍윤표.
        // 섭취칼로리 활동량 비례 계산 공식 추가.
        dailyIntakeCalorie = (int) (dailyIntakeCalorie * activityType.getVolume());

        log.info("activityType : " + activityType.getVolume());

        return dailyIntakeCalorie;
    }

    // added by 홍윤표. 일일 단백질 섭취량 계산 추가. (2020.07.11 19:55:24)
    public int calculationDailyIntakeProtein(){
        return (int) (calculationDailyIntakeCalorie() * 0.3) / 4;
    }

    // added by 홍윤표. 일일 지방 섭취량 계산 추가. (2020.07.11 19:55:27)
    public int calculationDailyIntakeFat(){
        return (int) (calculationDailyIntakeCalorie() * 0.4) / 9;
    }

    // added by 홍윤표. 일일 탄수화물 섭취량 계산 추가. (2020.07.11 19:55:29)
    public int calculationDailyIntakeCarbohydrate(){
        return (int) (calculationDailyIntakeCalorie() * 0.4) / 4;
    }

    // added by 홍윤표. 아침/점심/저녁/ 간식 식사 기준량 (2020.07.11 22:10:20)
    public Integer calculationDailyIntakeCalorie(EMealType mealType) {
        return (int) Math.round(calculationDailyIntakeCalorie() * getRatioByMealType(mealType));
    }

    // added by 홍윤표. 아침/점심/저녁/ 간식 식사 기준량 (2020.07.11 22:10:21)
    public Integer calculationDailyIntakeCarbohydrate(EMealType mealType) {
        return (int) Math.round(calculationDailyIntakeCarbohydrate() * getRatioByMealType(mealType));
    }

    // added by 홍윤표. 아침/점심/저녁/ 간식 식사 기준량 (2020.07.11 22:10:22)
    public Integer calculationDailyIntakeFat(EMealType mealType) {
        return (int) Math.round(calculationDailyIntakeFat() * getRatioByMealType(mealType));
    }

    // added by 홍윤표. 아침/점심/저녁/ 간식 식사 기준량 (2020.07.11 22:10:24)
    public Integer calculationDailyIntakeProtein(EMealType mealType) {
        return (int) Math.round(calculationDailyIntakeProtein() * getRatioByMealType(mealType));
    }

    private double getRatioByMealType(EMealType mealType) {
        return !mealType.name().equals("DESSERT") ? 0.3 : 0.1;
    }
}