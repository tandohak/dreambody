package com.dreambody.dbenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EMealType {

    BREAKFAST("1", "아침"),
    LUNCH("2", "점심"),
    DINNER("3", "저녁"),
    DESSERT("4", "간식");

    private final String mealTypeCode;
    private final String viewName;
}
