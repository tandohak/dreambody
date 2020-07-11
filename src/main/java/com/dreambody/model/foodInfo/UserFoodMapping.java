package com.dreambody.model.foodInfo;

import com.dreambody.model.BaseTimeEntity;
import com.dreambody.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

/**
 * @author : 이병덕
 * @description : 사용자가 저장하는 식품정보의 매핑 테이블
 * @date : 2020.07.08 22:08:36
 */

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFoodMapping extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1)
    @Max(value = 100)
    @Column(nullable = false, length = 100)
    private int quantity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "meal_type_id", nullable = false)
    private MealType mealType;

    @ManyToOne
    @JoinColumn(name = "food_info_id", nullable = false)
    private FoodInfo foodInfo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
