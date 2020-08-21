package com.dreambody.resolver;

import com.dreambody.model.foodInfo.WaterInfo;
import com.dreambody.resolver.request.water.WaterInfoRequest;
import com.dreambody.service.water.WaterInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : 이병덕
 * @description : 물 저장하는 리졸버
 * @date : 2020.08.20 23:04:21
 */

@RequiredArgsConstructor
@Component
public class WaterInfoResolver implements GraphQLQueryResolver {

    private final WaterInfoService waterInfoService;

    @GraphQLQuery(name = "waterInfo")
    public WaterInfo getWaterInfo(WaterInfoRequest waterInfoRequest) {
        return waterInfoService.getWaterInfo(waterInfoRequest);
    }
}
