package com.dreambody.controller.foodApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author : 이병덕
 * @decription : 식품안전나라 API 응답 Dto
 * @date : 2020.06.26
 */

@Getter
public class FoodInfoResponseDto {

    // @JsonProperty : 응답 json의 명을 매핑
    @JsonProperty(value = "I2790")
    private I2790 i2790;
}
