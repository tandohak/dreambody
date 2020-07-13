package com.dreambody.service.foodApi;

import com.dreambody.controller.foodApi.dto.FoodInfoResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class FoodInfoService {

    private RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://openapi.foodsafetykorea.go.kr/api/36d866bb8cd24a51bcfd/I2790/json/1/15/DESC_KOR=";

    public ResponseEntity<FoodInfoResponseDto> findFoodApi(String foodName) {
        ResponseEntity<FoodInfoResponseDto> foodInfoResponseDto = restTemplate.getForEntity(url + foodName, FoodInfoResponseDto.class);

        return foodInfoResponseDto;
    }
}
