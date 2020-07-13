package com.dreambody.resolver;

import com.dreambody.model.userInit.Activity;
import com.dreambody.model.userInit.Gender;
import com.dreambody.repository.userInit.ActivityRepository;
import com.dreambody.repository.userInit.GenderRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 이병덕
 * @description GraphQL. ActivityResolver 생성.
 * @date 2020.07.05
 */

@Component
@RequiredArgsConstructor
public class ActivityResolver implements GraphQLQueryResolver {

    private final ActivityRepository activityRepository;

    @GraphQLQuery(name = "activities")
    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }
}
