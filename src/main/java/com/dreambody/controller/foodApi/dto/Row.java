package com.dreambody.controller.foodApi.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : 이병덕
 * @decription : 식품안전나라 API row Array 객체, API 음식정보 리턴
 * @date : 2020.06.26
 */

@Getter
@Setter
@ToString
public class Row {

    @JsonAlias(value = "FOOD_CD")
    private String code;

    @JsonAlias(value = "DESC_KOR")
    private String name;

    @JsonAlias(value = "NUTR_CONT1")
    private float calorie;

    @JsonAlias(value = "NUTR_CONT2")
    private float carbohydrate;

    @JsonAlias(value = "NUTR_CONT3")
    private float protein;

    @JsonAlias(value = "NUTR_CONT4")
    private float fat;

    @JsonAlias(value = "GROUP_NAME")
    private String type;
}
