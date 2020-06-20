package com.dreambody.repository.userInit;

import com.dreambody.model.userInit.Activity;
import com.dreambody.model.userInit.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
