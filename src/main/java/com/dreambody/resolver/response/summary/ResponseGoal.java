package com.dreambody.resolver.response.summary;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseGoal {

    private Integer calorie;
    private Integer carbohydrate;
    private Integer protein;
    private Integer fat;
}
