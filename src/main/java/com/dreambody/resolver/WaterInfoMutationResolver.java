package com.dreambody.resolver;

import com.dreambody.model.foodInfo.WaterInfo;
import com.dreambody.resolver.request.water.WaterInfoRequest;
import com.dreambody.service.water.WaterInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import io.leangen.graphql.annotations.GraphQLMutation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : 이병덕
 * @description : 물 저장하는 리졸버
 * @date : 2020.08.20 23:04:21
 */

@RequiredArgsConstructor
@Component
public class WaterInfoMutationResolver implements GraphQLMutationResolver {

    private final WaterInfoService waterInfoService;

    @GraphQLMutation(name = "saveWaterInfo")
    public WaterInfo saveWaterInfo(WaterInfoRequest waterInfoRequest) {
        return waterInfoService.saveWaterInfo(waterInfoRequest);
    }
}
