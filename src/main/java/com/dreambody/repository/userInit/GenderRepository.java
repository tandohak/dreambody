package com.dreambody.repository.userInit;

import com.dreambody.model.userInit.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
