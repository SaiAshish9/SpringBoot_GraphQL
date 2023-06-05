package com.sai.graphql_server.bank.query;

import com.sai.graphql_server.GraphqlServerApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;

@Configuration
@Import(GraphqlServerApplication.class)
public class TestGraphqlServerApplication {


    @Bean
    @Primary
    public Clock testClock(){
      return Clock.fixed(LocalDate.of(2023, 6, 4).atStartOfDay(UTC).toInstant(), UTC);
    }

}
