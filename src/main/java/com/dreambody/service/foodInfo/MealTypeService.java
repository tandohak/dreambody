package com.dreambody.service.foodInfo;

import com.dreambody.repository.foodInfo.MealTypeRepository;
import com.dreambody.resolver.response.foodInfo.MealTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 이병덕
 * @description : 식사타입 서비스
 * @date : 2020.07.11 20:11:22
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class MealTypeService {
    private final MealTypeRepository mealTypeRepository;

    public List<MealTypeResponse> load() {
        return mealTypeRepository.findAll()
                .stream()
                .map(MealTypeResponse::new)
                .collect(Collectors.toList());
    }
}
