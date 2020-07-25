package com.dreambody.controller.foodApi;

import com.dreambody.controller.foodApi.dto.FoodInfoResponseDto;
import com.dreambody.service.foodApi.FoodInfoService;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 이병덕
 * @description : 식품 api
 * @date : 2020.06.22
 */
@RequiredArgsConstructor
@RestController
public class FoodInfoController {

    private final FoodInfoService foodInfoService;

//    @GetMapping("/foodInfo")
    @GraphQLQuery(name = "foodInfo")
    public ResponseEntity<FoodInfoResponseDto> findFoodApi(@RequestParam("name") String foodName) {
        return foodInfoService.findFoodApi(foodName);
    }
}
