package com.dreambody.resolver.response.summary;

import lombok.*;

/**
 *   @author 홍윤표
 *   @description 요약 정보를 위한 ResponseSummary 클래스 생성
 *   @date 2020.07.11 18:51:54
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class ResponseSummary {
    private ResponseGoal goal;
    private ResponseIntake intake;
}
