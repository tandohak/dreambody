package com.dreambody.resolver;

import com.dreambody.model.userInit.Goal;
import com.dreambody.repository.userInit.GoalRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 이병덕
 * @description GraphQL. GoalResolver 생성.
 * @date 2020.07.05
 */

@Component
@RequiredArgsConstructor
public class GoalResolver implements GraphQLQueryResolver {

    private final GoalRepository goalRepository;

    @GraphQLQuery(name = "goals")
    public List<Goal> getGoals() {
        return goalRepository.findAll();
    }
}
