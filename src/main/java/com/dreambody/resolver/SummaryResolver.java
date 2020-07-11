package com.dreambody.resolver;

import com.dreambody.resolver.response.summary.SummaryResponse;
import com.dreambody.service.facade.SummaryServiceFacade;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *   @author 홍윤표
 *   @description 요약 리졸버 생성.
 *   @date 2020.07.11 14:47:01
 */

@Component
@RequiredArgsConstructor
public class SummaryResolver implements GraphQLQueryResolver {
    private final @Qualifier("summaryService") SummaryServiceFacade summaryService;

    @GraphQLQuery(name = "summary")
    public SummaryResponse getSummary() {
        return summaryService.loadSummaryData();
    }

}
