package com.dreambody.service.facade;

import com.dreambody.resolver.response.summary.SummaryResponse;
import org.springframework.stereotype.Service;

@Service
public interface SummaryServiceFacade {
    SummaryResponse loadSummaryData();
}
