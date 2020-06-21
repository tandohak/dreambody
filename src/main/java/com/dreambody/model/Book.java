package com.dreambody.model;

import lombok.*;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Book {
    private String title;
    private String isbn;
}