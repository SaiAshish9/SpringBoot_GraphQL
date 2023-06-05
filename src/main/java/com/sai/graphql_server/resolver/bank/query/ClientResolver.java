package com.sai.graphql_server.resolver.bank.query;

import com.sai.graphql_server.domain.bank.BankAccount;
import com.sai.graphql_server.domain.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public CompletableFuture<Client> client(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Requesting client data for bank account id {}", bankAccount.getId());
                    return Client.builder()
                            .id(UUID.randomUUID())
                            .firstName("Sai")
                            .lastName("Ashish")
                            .build();
                }
                ,executorService
        );
    }

//     public Client client(BankAccount bankAccount){
//          log.info("Requesting client data for bank account id {}", bankAccount.getId());
//          throw new RuntimeException("Error");
//          return Client.builder()
//                  .id(UUID.randomUUID())
//                  .firstName("Sai")
//                  .lastName("Ashish")
//                  .build();
//     }

//    public DataFetcherResult<Client> client(BankAccount bankAccount) {
//        log.info("Requesting client data for bank account id {}", bankAccount.getId());
//        return DataFetcherResult.<Client>newResult()
//                .data(Client.builder()
//                        .id(UUID.randomUUID())
//                        .firstName("Sai")
//                        .lastName("Ashish")
//                        .build()
//                )
//                .error(new GenericGraphQLError("could not get sub client id"))
//                .build();
//    }

}
