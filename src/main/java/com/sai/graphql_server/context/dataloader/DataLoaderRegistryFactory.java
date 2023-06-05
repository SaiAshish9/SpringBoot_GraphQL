package com.sai.graphql_server.context.dataloader;

import com.sai.graphql_server.service.BalanceService;
import com.sai.graphql_server.util.CorrelationIdPropagationExecutor;
import lombok.RequiredArgsConstructor;

import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.dataloader.DataLoaderRegistry;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {
    private final BalanceService balanceService;

    public static final String BALANCE_DATA_LOADER = "BALANCE_DATA_LOADER";
    private static final Executor balanceThreadPool =
            CorrelationIdPropagationExecutor.wrap(
                    Executors
                            .newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
//  new DelegatingSecurityContextExecutorService(Executors
//                            .newFixedThreadPool(Runtime.getRuntime().availableProcessors())))

    public DataLoaderRegistry create(String userId) {
        var registry = new DataLoaderRegistry();
        registry.register(BALANCE_DATA_LOADER, createBalanceDataLoader(userId));
        return registry;
    }

    private DataLoader<UUID, BigDecimal> createBalanceDataLoader(String userId) {
        return DataLoader.newMappedDataLoader((bankAccountIds, environment) ->
                        CompletableFuture.supplyAsync(() -> {
                            return balanceService.getBalanceFor((Map) environment.getKeyContexts(), userId);
                        }, balanceThreadPool),
                DataLoaderOptions.newOptions().setBatchLoaderContextProvider(() -> "this is the context")
        );
    }

}
