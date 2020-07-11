package com.dreambody.resolver.response.foodInfo;

import com.dreambody.model.foodInfo.MealType;
import lombok.*;

/**
 * @author : 이병덕
 * @description : 식사타입 응답 객체
 * @date : 2020.07.11 19:57:54
 */

@Data @ToString
public class MealTypeResponse {

    private Long id;
    private String type;

    @Builder
    public MealTypeResponse(MealType mealType) {
        this.id = mealType.getId();
        this.type = mealType.getType();
    }
}
