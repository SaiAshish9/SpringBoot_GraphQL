package com.sai.graphql_server.resolver.bank.query;

import com.sai.graphql_server.context.dataloader.DataLoaderRegistryFactory;
import com.sai.graphql_server.domain.bank.BankAccount;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLResolver<BankAccount> {

//    @PreAuthorize("hasAuthority('get:bank_account_balance')")
    public CompletableFuture<BigDecimal> balance(BankAccount bankAccount, DataFetchingEnvironment environment) throws InterruptedException {
//       Thread.sleep(3000L); Un-acceptable
        log.info("Getting balance for {}", bankAccount.getId());
        DataLoader<UUID, BigDecimal> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.BALANCE_DATA_LOADER);
        return dataLoader.load(bankAccount.getId(), bankAccount);
    }

}
