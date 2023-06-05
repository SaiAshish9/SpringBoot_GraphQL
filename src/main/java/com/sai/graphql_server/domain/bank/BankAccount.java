package com.sai.graphql_server.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Value
public class BankAccount {
    UUID id;
    Client client;
    Currency currency;
    ZonedDateTime createdAt;
    LocalDate createdOn;
    BigDecimal balance;
}
