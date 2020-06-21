package com.dreambody.controller.userInit.dto;

import com.dreambody.model.userInit.Gender;
import com.dreambody.model.userInit.Goal;
import lombok.Getter;

/**
 * @author : 이병덕
 * @decription : Goal Entity의 응답 Dto
 * @date : 2020.06.21
 */

@Getter
public class GoalResponseDto {

    private Long id;
    private String goal;

    public GoalResponseDto(Goal entity) {
        this.id = entity.getId();
        this.goal = entity.getGoal();
    }
}
