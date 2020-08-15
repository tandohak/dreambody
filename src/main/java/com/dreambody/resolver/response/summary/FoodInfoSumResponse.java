package com.dreambody.resolver.response.summary;

import com.dreambody.resolver.request.nutrition.FoodInfoRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author : 이병덕
 * @description : 저장한 음식 정보를 합산하는 클래스
 * @date : 2020.08.15 17:54:02
 */

@Slf4j
@Getter
public class FoodInfoSumResponse {

    private Float protein = 0F;
    private Float fat = 0F;
    private Float carbohydrate = 0F;
    private Float calorie = 0F;

    @Builder
    public FoodInfoSumResponse (List<FoodInfoRequest> foodInfoRequests) {
        for (FoodInfoRequest foodInfoRequest : foodInfoRequests) {
            protein += foodInfoRequest.getProtein();
            fat += foodInfoRequest.getFat();
            carbohydrate += foodInfoRequest.getCarbohydrate();
            calorie += foodInfoRequest.getCalorie();
        }
    }
}
