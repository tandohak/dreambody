package com.dreambody.service.facade.summary;

import com.dreambody.resolver.request.summary.RequestSummary;
import com.dreambody.resolver.response.summary.ResponseSummary;
import org.springframework.stereotype.Service;

/**
 *   @author 홍윤표
 *   @description 요약 서비스 퍼사드 새성.
 *   @date 2020.07.11 18:38:16
 */

@Service
public interface SummaryServiceFacade {
    ResponseSummary loadSummaryData(RequestSummary requestSummary);
}
