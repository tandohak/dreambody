package com.dreambody.repository.foodInfo;

import com.dreambody.dbenum.EMealType;
import com.dreambody.model.User;
import com.dreambody.model.foodInfo.UserFoodMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserFoodMappingRepository extends JpaRepository<UserFoodMapping, Long> {

    List<UserFoodMapping> findByUserIdAndMealType(Long userId, EMealType mealType1);
    List<UserFoodMapping> findByUserId(Long userId);
    List<UserFoodMapping> findAllByUserAndRegistrationDate(User user, LocalDate registrationDate);
    List<UserFoodMapping> findAllByUserAndRegistrationDateAndMealType(User user, LocalDate registrationDate, EMealType mealType);
}
