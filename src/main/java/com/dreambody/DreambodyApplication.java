package com.dreambody;

import com.dreambody.config.AppProperties;
import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//TODO : EnableJpaAuditing 문제 해결.
@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DreambodyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreambodyApplication.class, args);
    }

}
