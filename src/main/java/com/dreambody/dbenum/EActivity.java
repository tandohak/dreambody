package com.dreambody.dbenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EActivity {

    IN_ACTIVE("1", "주로 좌식 생활을 하는 사람", 1.2F),
    LITTLE_ACTIVE("2", "약간 활동적인 사람(주당 1일 ~ 3일 운동)", 1.3F),
    NORMAL_ACTIVE("3", "보통(주당 3일 ~ 5일 이상 운동)", 1.5F),
    FAIRLY_ACTIVE("4", "상당히 활동적인 사람(매일 운동)", 1.7F),
    VERY_ACTIVE("5", "매우 활동적(운동선수와 비슷한 강도로 매일 운동)", 1.9F);

    private final String activeCode;
    private final String viewName;
    private final Float volume;
}
