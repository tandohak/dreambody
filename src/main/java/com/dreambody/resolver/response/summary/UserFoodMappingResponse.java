package com.dreambody.resolver.response.summary;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.FoodInfo;
import com.dreambody.model.foodInfo.MealType;
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
    private MealType mealType;
    private FoodInfo foodInfo;
    private User user;

    public UserFoodMappingResponse(UserFoodMapping userFoodMappinge) {
        this.id = userFoodMappinge.getId();
        this.quantity = userFoodMappinge.getQuantity();
        this.registrationDate = userFoodMappinge.getRegistrationDate();
        this.mealType = userFoodMappinge.getMealType();
        this.foodInfo = userFoodMappinge.getFoodInfo();
        this.user = userFoodMappinge.getUser();
    }
}
