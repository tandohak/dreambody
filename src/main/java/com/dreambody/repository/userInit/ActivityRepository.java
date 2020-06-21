package com.dreambody.repository.userInit;

import com.dreambody.model.userInit.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
