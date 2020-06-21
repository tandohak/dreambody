package com.dreambody.service.userInit;

import com.dreambody.controller.userInit.dto.GenderResponseDto;
import com.dreambody.repository.userInit.GenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 이병덕
 * @description : Gender Entity Serivce
 * @date : 2020.06.21
 */

@RequiredArgsConstructor
@Service
public class GenderService {

    private final GenderRepository genderRepository;

    // 성별 조회
    @Transactional(readOnly = true)
    public List<GenderResponseDto> findAll() {
        return genderRepository.findAll().stream()
                .map(GenderResponseDto::new)
                .collect(Collectors.toList());
    }
}
