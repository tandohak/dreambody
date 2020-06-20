package com.dreambody.controller.userInit.dto;

import com.dreambody.model.userInit.Gender;
import lombok.Getter;

/**
 * @author : 이병덕
 * @decription : Gender Entity의 응답 Dto
 * @date : 2020.06.21
 */

@Getter
public class GenderResponseDto {

    private Long id;
    private String gender;

    public GenderResponseDto(Gender entity) {
        this.id = entity.getId();
        this.gender = entity.getGender();
    }
}
