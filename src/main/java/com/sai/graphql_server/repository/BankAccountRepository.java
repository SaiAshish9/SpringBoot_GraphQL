package com.sai.graphql_server.repository;

import com.sai.graphql_server.domain.bank.BankAccount;
import com.sai.graphql_server.domain.bank.Currency;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BankAccountRepository {

   private final List<BankAccount> bankAccounts = List.of(
           BankAccount.builder()
                   .id(UUID.fromString("770e9b38-0195-4af4-a784-89954fe127f1"))
                   .currency(Currency.USD)
                   .createdAt(ZonedDateTime.parse("2023-06-04T05:33:54.250Z"))
                   .build(),
           BankAccount.builder()
                   .id(UUID.fromString("770e9b38-0195-4af4-a784-89954fe127f2"))
                   .currency(Currency.USD)
                   .createdAt(ZonedDateTime.parse("2023-06-04T05:33:54.250Z"))
                   .build(),
           BankAccount.builder()
                   .id(UUID.fromString("770e9b38-0195-4af4-a784-89954fe127f3"))
                   .currency(Currency.USD)
                   .createdAt(ZonedDateTime.parse("2023-06-04T05:33:54.250Z"))
                   .build(),
           BankAccount.builder()
                   .id(UUID.fromString("770e9b38-0195-4af4-a784-89954fe127f4"))
                   .currency(Currency.USD)
                   .createdAt(ZonedDateTime.parse("2023-06-04T05:33:54.250Z"))
                   .build()
   ).stream().sorted(Comparator.comparing(BankAccount::getId))
   .collect(Collectors.toUnmodifiableList());

   public List<BankAccount> getBankAccounts(){
      return bankAccounts;
   }

   public List<BankAccount> getBankAccountsAfter(UUID id){
      return bankAccounts.stream()
              .dropWhile(bankAccount -> bankAccount.getId().compareTo(id) != 1)
              .collect(Collectors.toUnmodifiableList());
   }

}
