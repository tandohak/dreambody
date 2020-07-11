package com.dreambody.resolver.response.summary;

import lombok.*;


@Builder @Data @ToString
public class SummaryResponse {
    private Integer intakeCalorie;
    private Integer goalCalorie;
    private Integer intakeCarbohydrate;
    private Integer goalCarbohydrate;
    private Integer intakeProtein;
    private Integer goalProtein;
    private Integer intakeFat;
    private Integer goalFat;
}
