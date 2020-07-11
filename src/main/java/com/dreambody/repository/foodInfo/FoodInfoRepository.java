package com.dreambody.repository.foodInfo;

import com.dreambody.model.foodInfo.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodInfoRepository extends JpaRepository<FoodInfo, Long> {
}
