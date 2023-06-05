package com.sai.graphql_server.bank.query;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.maven.surefire.shared.io.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestGraphqlServerApplication.class)
@RequiredArgsConstructor
public class BankAccountQueryResolverIT {

   private static final String GRAPHQL_QUERY_REQ_PATH = "graphql/request/%s.graphql";
   private static final String GRAPHQL_QUERY_RES_PATH = "graphql/response/%s.json";

   @Autowired
   GraphQLTestTemplate graphQLTestTemplate;

   @Test
   void bank_accounts_are_returned() throws IOException, JSONException {
       var testName = "bank_account";
       GraphQLResponse graphQLResponse =
       graphQLTestTemplate.postForResource(String.format(GRAPHQL_QUERY_REQ_PATH, testName));
       var expectedResponseBody = read(String.format(GRAPHQL_QUERY_RES_PATH, testName));
       assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
       assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody(), true);
   }

   private String read(String location) throws IOException {
       return IOUtils.toString(new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
   }

}
