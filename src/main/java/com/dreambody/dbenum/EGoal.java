package com.dreambody.dbenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EGoal {

    WEIGHT_LOSS("1", "체중감량"),
    WEIGHT_GAIN("2", "체중증가"),
    WEIGHT_RETENTION("3", "체중유지");

    private final String goalCode;
    private final String viewName;
}
