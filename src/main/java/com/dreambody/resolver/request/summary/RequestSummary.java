package com.dreambody.resolver.request.summary;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestSummary {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    private Long mealType;
}
