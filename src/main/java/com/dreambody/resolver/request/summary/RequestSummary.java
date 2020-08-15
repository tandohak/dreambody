package com.dreambody.resolver.request.summary;

import com.dreambody.dbenum.EMealType;
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

    private EMealType mealType;
}
