package com.dreambody.resolver.request.nutrition;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.MealType;
import com.dreambody.model.foodInfo.UserFoodMapping;
import lombok.*;

/**
 * @author : 이병덕
 * @description : 아침, 점심, 저녁, 간식 저장 시 UserFoodMapping 요청
 * @date : 2020.07.11 22:21:06
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserFoodMappingRequest {

    private Long mealType;
    private Long foodInfo;
    private Long user;
    private int quantity;
    private String registrationDate;

    public UserFoodMapping toEntity() {
        return UserFoodMapping.builder()
                        .mealType(MealType.builder().id(mealType).build())
                        .foodInfo(FoodInfo.builder().id(foodInfo).build())
                        .user(User.builder().id(user).build())
                        .quantity(quantity)
                        .registrationDate(null)
                        .build();
    }
}
