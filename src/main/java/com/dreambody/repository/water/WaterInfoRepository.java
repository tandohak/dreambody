package com.dreambody.repository.water;

import com.dreambody.model.foodInfo.WaterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * @author : 이병덕
 * @description : 물 저장, 조회하는 리파지토리
 * @date : 2020.08.20 23:08:26
 */

@Repository
public interface WaterInfoRepository extends JpaRepository<WaterInfo, Long> {

    WaterInfo findByUserIdAndRegistrationDate(Long userId, LocalDate RegistrationDate);
}
