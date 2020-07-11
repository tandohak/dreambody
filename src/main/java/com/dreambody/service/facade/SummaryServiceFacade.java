package com.dreambody.service.facade;

import com.dreambody.resolver.response.summary.SummaryResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface SummaryServiceFacade {
    SummaryResponse loadSummaryData(LocalDate registrationDate);
}
