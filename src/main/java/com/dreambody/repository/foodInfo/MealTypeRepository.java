package com.dreambody.repository.foodInfo;

import com.dreambody.model.foodInfo.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTypeRepository extends JpaRepository<MealType, Long> {
}
