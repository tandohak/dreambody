package com.dreambody.resolver.request.nutrition;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.MealType;
import com.dreambody.model.foodInfo.UserFoodMapping;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author : 이병덕
 * @description : 아침, 점심, 저녁, 간식 저장 시 식사타입과 식품정보 요청
 * @date : 2020.07.11 22:21:06
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class FoodInfoRequest {

    // FoodInfo
    // 프론트
    private String code;
    private String name;
    private Float protein;
    private Float fat;
    private Float carbohydrate;
    private Float calorie;

    // UserFoodMapping
    private Long foodInfo;
    private Long user;
    private Long mealType;     // 프론트
    private int quantity;      // 프론트
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate; // 프론트

    public FoodInfo toFoodInfoEntity() {
        return FoodInfo.builder()
                        .code(code)
                        .name(name)
                        .protein(protein)
                        .fat(fat)
                        .carbohydrate(carbohydrate)
                        .calorie(calorie)
                        .build();
    }

    public UserFoodMapping toUserFoodMappingEntity() {
        return UserFoodMapping.builder()
                .quantity(quantity)
                .registrationDate(LocalDate.now())
                .mealType(MealType.builder().id(mealType).build())
                .foodInfo(FoodInfo.builder().id(foodInfo).build())
                .user(User.builder().id(user).build())
                .build();
    }

    public void generateUserFoodMappingRequest(Long foodInfoId, Long userId) {
        this.foodInfo = foodInfoId;
        this.user = userId;
    }
}
