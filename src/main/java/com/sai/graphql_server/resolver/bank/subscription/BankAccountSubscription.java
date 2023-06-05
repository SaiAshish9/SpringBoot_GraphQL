package com.sai.graphql_server.resolver.bank.subscription;

import com.sai.graphql_server.domain.bank.BankAccount;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BankAccountSubscription implements GraphQLSubscriptionResolver {

    public Publisher<BankAccount> bankAccounts() {
        return null;
    }

    public Publisher<BankAccount> bankAccount(UUID id) {
        return null;
    }


}
