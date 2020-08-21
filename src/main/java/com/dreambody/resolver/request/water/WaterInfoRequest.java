package com.dreambody.resolver.request.water;

import com.dreambody.model.User;
import com.dreambody.model.foodInfo.WaterInfo;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public class WaterInfoRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    private int amountWater;

    public WaterInfo toEntity(Long userId) {
        return WaterInfo.builder()
                        .registrationDate(registrationDate)
                        .amountWater(amountWater)
                        .user(User.builder().id(userId).build())
                        .build();
    }
}
