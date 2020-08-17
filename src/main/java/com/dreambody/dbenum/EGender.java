package com.dreambody.dbenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EGender {

    MALE("1", "남"),
    FEMALE("2", "여");

    private final String genderCode;
    private final String viewName;
}
