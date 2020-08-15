package com.dreambody.repository;

import com.dreambody.model.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long> {
    BlackList findByToken(String token);
}
