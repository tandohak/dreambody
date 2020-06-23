package com.dreambody.service.foodApi;

import com.dreambody.controller.foodApi.dto.FoodInfoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FoodInfoService {

    RestTemplate restTemplate = new RestTemplate();

//    public ResponseEntity<FoodInfoResponseDto> findFoodApi() {
    public FoodInfoResponseDto findFoodApi() {
        System.out.println(restTemplate.getForObject("http://openapi.foodsafetykorea.go.kr/api/36d866bb8cd24a51bcfd/I2790/json/1/5", FoodInfoResponseDto.class).toString());
        return restTemplate.getForObject("http://openapi.foodsafetykorea.go.kr/api/36d866bb8cd24a51bcfd/I2790/json/1/5", FoodInfoResponseDto.class);
//        return apiResultHandler();
    }

//    private JSONObject apiResult() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        return restTemplate.getForObject("http://openapi.foodsafetykorea.go.kr/api/36d866bb8cd24a51bcfd/I2790/json/1/5" , JSONObject.class);
//    }
//
//    private List<FoodInfoResponseDto> apiResultHandler(String food) {
//        JSONObject I2790 = apiResult().getJSONObject("I2790");
//        JSONObject RESULT = I2790.getJSONObject("RESULT");
//        String CODE = RESULT.getString("CODE");
//        String MSG = RESULT.getString("MSG");
//
//        JSONArray rows = I2790.getJSONArray("row");
//
//        for(int i=0; i<rows.length(); i++) {
//            JSONObject row = rows.getJSONObject(i);
//
//            String foodNm = row.getString("DESK_KOR");
//            String foodCd = row.getString("FOOD_CD");
//            float calorie = row.getFloat("NUTR_CONT1");      // 칼로리      NUTR_CONT1
//            float carbohydrate = row.getFloat("NUTR_CONT2"); // 탄수화물    NUTR_CONT2
//            float protein = row.getFloat("NUTR_CONT3");      // 단백질      NUTR_CONT3
//
//            foodInfoResponseDtos.add(FoodInfoResponseDto.builder()
//                    .code(CODE)
//                    .msg(MSG)
//                    .foodCd(foodNm)
//                    .foodNm(foodNm)
//                    .calorie(calorie)
//                    .carbohydrate(carbohydrate)
//                    .protein(protein)
//                    .build());
//        }
//
//         return foodInfoResponseDtos;
//    }
}
