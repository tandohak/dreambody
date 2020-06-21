package com.dreambody.resolver;

import com.dreambody.model.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {
    public Book getBook(String isbn) {
        return Book.builder().title("asdasdas").isbn("12312312").build();
    }

}
