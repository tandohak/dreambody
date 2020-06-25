package com.dreambody.controller.foodApi.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

/**
 * @author : 이병덕
 * @decription : 식품안전나라 API row Array 객체, API 음식정보 리턴
 * @date : 2020.06.26
 */

@ToString
public class Row {

    @JsonProperty(value = "FOOD_CD")
    private String foodCode;
    @JsonProperty(value = "DESC_KOR")
    private String foodName;
    @JsonProperty(value = "NUTR_CONT1")
    private float calorie;
    @JsonProperty(value = "NUTR_CONT2")
    private float carbohydrate;
    @JsonProperty(value = "NUTR_CONT3")
    private float protein;
    @JsonProperty(value = "GROUP_NAME")
    private String foodType;
}
