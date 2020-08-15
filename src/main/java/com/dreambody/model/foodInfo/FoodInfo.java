package com.dreambody.model.foodInfo;

import com.dreambody.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author : 이병덕
 * @description : 사용자가 저장한 식품정보
 * @date : 2020.07.08
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
public class FoodInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float protein;

    @Column(nullable = false)
    private Float fat;

    @Column(nullable = false)
    private Float carbohydrate;

    @Column(nullable = false)
    private Float calorie;
}
