package com.dreambody.controller.foodApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

/**
 * @author : 이병덕
 * @decription : 식품안전나라 API RESULT 객체, API 결과 상태를 가짐
 * @date : 2020.06.26
 */

@ToString
public class Result {

    @JsonProperty(value = "MSG")
    private String msg;
    @JsonProperty(value = "CODE")
    private String code;
}
