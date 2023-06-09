package com.sai.graphql_server;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GraphqlServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlServerApplication.class, args);
	}

//	@Bean
//    @ConditionalOnProperty( prefix = "graphql.tracing", name = "enabled", matchIfMissing = true)
//    public Instrumentation tracingInstrumentation(){
//        return new TracingInstrumentation();
//    }

}
