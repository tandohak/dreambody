package com.dreambody.controller.userInit.dto;

import com.dreambody.model.userInit.Activity;
import com.dreambody.model.userInit.Goal;
import lombok.Getter;

/**
 * @author : 이병덕
 * @decription : Activituy Entity의 응답 Dto
 * @date : 2020.06.21
 */

@Getter
public class ActivityResponseDto {

    private Long id;
    private String activity;
    private float decimal;

    public ActivityResponseDto(Activity entity) {
        this.id = entity.getId();
        this.activity = entity.getActivity();
        this.decimal = entity.getDecimal();
    }
}
