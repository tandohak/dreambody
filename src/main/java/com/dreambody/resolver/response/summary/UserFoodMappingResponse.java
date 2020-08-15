package com.dreambody.resolver.response.summary;

import com.dreambody.dbenum.EMealType;
import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.UserFoodMapping;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

/**
 * @author : 이병덕
 * @description : 유저음식매핑 테이블 응답 객체
 * @date : 2020.07.12 05:03:32
 */

@Getter
@ToString
public class UserFoodMappingResponse {

    private Long id;
    private int quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
    private EMealType mealType;
    private FoodInfo foodInfo;
    private User user;

    public UserFoodMappingResponse(UserFoodMapping userFoodMapping) {
        this.id = userFoodMapping.getId();
        this.quantity = userFoodMapping.getQuantity();
        this.registrationDate = userFoodMapping.getRegistrationDate();
        this.mealType = userFoodMapping.getMealType();
        this.foodInfo = userFoodMapping.getFoodInfo();
        this.user = userFoodMapping.getUser();
    }
}
