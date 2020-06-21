package com.dreambody.controller.userInit.dto;

import com.dreambody.model.userInit.Activity;
import com.dreambody.model.userInit.Gender;
import com.dreambody.model.userInit.Goal;
import com.dreambody.model.userInit.UserInfo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author : 이병덕
 * @decription : UserInfo Entity의 요청 Dto
 * @date : 2020.06.21
 */

@Getter
public class UserInfoSaveRequestDto {

    private int currentWeight;
    private int goalWeight;
    private int height;
    private String dateOfBirth;
    private Gender gender;
    private Goal goal;
    private Activity activity;

    @Builder
    public UserInfoSaveRequestDto(int currentWeight, int goalWeight, int height, String dateOfBirth, Gender gender, Goal goal, Activity activity) {
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.goal = goal;
        this.activity = activity;
    }

    public UserInfo toEntity() {
        return UserInfo.builder().currentWeight(currentWeight)
                .goalWeight(goalWeight)
                .height(height)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .goal(goal)
                .activity(activity)
                .build();
    }
}
