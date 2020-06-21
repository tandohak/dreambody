package com.dreambody.service.userInit;

import com.dreambody.controller.userInit.dto.GenderResponseDto;
import com.dreambody.controller.userInit.dto.GoalResponseDto;
import com.dreambody.repository.userInit.GenderRepository;
import com.dreambody.repository.userInit.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 이병덕
 * @description : Goal Entity Serivce
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@Service
public class GoalService {

    private final GoalRepository goalRepository;

    // 성별 조회
    @Transactional(readOnly = true)
    public List<GoalResponseDto> findAll() {
        return goalRepository.findAll().stream()
                .map(GoalResponseDto::new)
                .collect(Collectors.toList());
    }
}
