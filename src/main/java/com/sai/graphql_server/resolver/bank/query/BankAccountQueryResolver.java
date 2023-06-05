package com.sai.graphql_server.resolver.bank.query;

import com.sai.graphql_server.connection.CursorUtil;
import com.sai.graphql_server.context.CustomGraphQLContext;
import com.sai.graphql_server.domain.bank.BankAccount;
import com.sai.graphql_server.domain.bank.Currency;
import com.sai.graphql_server.repository.BankAccountRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountQueryResolver implements GraphQLQueryResolver {

    private final BankAccountRepository bankAccountRepository;
    private final CursorUtil cursorUtil;

//    @PreAuthorize("hasAuthority('get:bank_account')")
    public BankAccount bankAccount(UUID id, DataFetchingEnvironment dataFetchingEnvironment){
        log.info("Retrieving bank account id: {}", id);
        CustomGraphQLContext customGraphQLContext = dataFetchingEnvironment.getContext();
        log.info(customGraphQLContext.getUserId());

        var requestedFields = dataFetchingEnvironment.getSelectionSet()
        .getFields()
        .stream().map(SelectedField::getName)
        .collect(Collectors.toUnmodifiableSet());

        if(requestedFields.contains("id")){
            System.out.println("id");
        }

        return BankAccount.builder()
                .id(id)
                .currency(Currency.USD)
                .createdAt(ZonedDateTime.now())
                .createdOn(LocalDate.now())
                .build();
    }

    public Connection<BankAccount> bankAccounts(int first, @Nullable String cursor){

       List<Edge<BankAccount>> edges = getBankAccounts(cursor)
               .stream()
               .map(bankAccount -> new DefaultEdge<>(bankAccount, cursorUtil.createCursorWith(bankAccount.getId())))
               .limit(first)
               .collect(Collectors.toUnmodifiableList());

       ConnectionCursor firstCursorFrom = cursorUtil.getFirstCursorFrom(edges);
       ConnectionCursor lastCursorFrom = cursorUtil.getLastCursorFrom(edges);

       var pageInfo = new DefaultPageInfo(
           firstCursorFrom,
           lastCursorFrom,
           cursor != null,
           edges.size() >= first
       );

       return new DefaultConnection<>(edges, pageInfo);
    }

    public List<BankAccount> getBankAccounts(String cursor){
      if(cursor == null)
          return bankAccountRepository.getBankAccounts();
      return bankAccountRepository.getBankAccountsAfter(cursorUtil.decode(cursor));
    }

}

//       log.info("Retrieving bank account id: {}", id);
//       var clientA = Client.builder()
//               .id(UUID.randomUUID())
//               .firstName("Sai")
//               .lastName("Ashish")
//               .build();
//        var clientB = Client.builder()
//                .id(UUID.randomUUID())
//                .firstName("Sai")
//                .lastName("Ashish9")
//                .build();
//        clientA.setClient(clientB);
//        clientB.setClient(clientA);
//       return BankAccount.builder().id(id).currency(Currency.USD).client(clientA)
//               .build();
