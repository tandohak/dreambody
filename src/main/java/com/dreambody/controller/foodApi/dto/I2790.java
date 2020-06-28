package com.dreambody.controller.foodApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

/**
 * @author : 이병덕
 * @decription : 식품안전나라 API I2790 객체, API 최상위 객체
 * @date : 2020.06.26
 */

@ToString
public class I2790 {

    @JsonProperty(value = "RESULT")
    private Result result;
    @JsonProperty(value = "row")
    private Row[] row;
}
