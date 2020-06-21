package com.dreambody.repository.userInit;

import com.dreambody.model.userInit.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}