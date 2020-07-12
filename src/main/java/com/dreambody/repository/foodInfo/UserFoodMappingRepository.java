package com.dreambody.repository.foodInfo;

import com.dreambody.model.foodInfo.UserFoodMapping;
import com.dreambody.resolver.response.summary.UserFoodMappingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserFoodMappingRepository extends JpaRepository<UserFoodMapping, Long> {
//    List<UserFoodMapping> findAllByUserIdxAndRegistrationDate(Long userIdx, LocalDate registrationDate);

    List<UserFoodMapping> findByUserIdAndMealTypeId(Long userId, Long mealTypeId);
    List<UserFoodMapping> findByUserId(Long userId);
}
