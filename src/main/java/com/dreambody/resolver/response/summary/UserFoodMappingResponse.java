package com.dreambody.resolver.response.summary;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.MealType;
import com.dreambody.model.foodInfo.UserFoodMapping;
import lombok.*;

/**
 * @author : 이병덕
 * @description : 유저음식매핑 테이블 응답 객체
 * @date : 2020.07.12 05:03:32
 */

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserFoodMappingResponse {

    private FoodInfo foodInfo;
    private MealType mealType;
    private User user;
    private UserFoodMapping userFoodMapping;
}
