package com.dreambody.controller.foodApi;

import com.dreambody.controller.foodApi.dto.FoodInfoResponseDto;
import com.dreambody.service.foodApi.FoodInfoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 이병덕
 * @description : 식품 api
 * @date : 2020.06.22
 */
@RequiredArgsConstructor
@RestController
public class FoodInfoController {

    private final FoodInfoService foodInfoService;

    @GetMapping("/foodInfo")
//    public ResponseEntity<FoodInfoResponseDto> findFoodApi() {
//        return foodInfoService.findFoodApi();
//    }
    public FoodInfoResponseDto findFoodApi() {
        return foodInfoService.findFoodApi();
    }
}
