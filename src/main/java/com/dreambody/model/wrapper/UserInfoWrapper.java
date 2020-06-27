package com.dreambody.model.wrapper;

import com.dreambody.model.userInit.Activity;
import com.dreambody.model.userInit.Gender;
import com.dreambody.model.userInit.Goal;
import com.dreambody.model.userInit.UserInfo;
import lombok.*;

/*
 *   @author 홍윤표
 *   @description UserInfo 저장을 위한 wrapper 클래스 생성.
 *   @date 2020.06.23 01:11:08
 */
@NoArgsConstructor @AllArgsConstructor
@Builder @Getter @Setter @ToString
public class UserInfoWrapper {
    private Integer currentWeight;

    private Integer goalWeight;

    private Integer height;

    private String dateOfBirth;

    private Long gender;

    private Long goal;

    private Long activity;

    public UserInfo toEntity() {
        UserInfo userInfo = UserInfo.builder()
                .currentWeight(currentWeight)
                .dateOfBirth(dateOfBirth)
                .goalWeight(goalWeight)
                .height(height)
                .gender(Gender.builder().id(gender).build())
                .goal(Goal.builder().id(goal).build())
                .activity(Activity.builder().id(activity).build())
                .build();

        userInfo.getDailyIntakeCalorie();

        return userInfo;
    }

    public UserInfo toEntity(UserInfo userInfo) {
        if (currentWeight != null) {
            userInfo.setCurrentWeight(currentWeight);
        }

        if (goalWeight != null) {
            userInfo.setGoalWeight(goalWeight);
        }

        if (height != null) {
            userInfo.setHeight(height);
        }

        if (dateOfBirth != null) {
            userInfo.setDateOfBirth(dateOfBirth);
        }

        if (gender != null) {
            userInfo.setGender(Gender.builder().id(gender).build());
        }

        if (goal != null) {
            userInfo.setGoal(Goal.builder().id(goal).build());
        }

        if (activity != null) {
            userInfo.setActivity(Activity.builder().id(activity).build());
        }

        userInfo.getDailyIntakeCalorie();

        return userInfo;
    }

}
