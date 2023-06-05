package com.sai.graphql_server.service;

import com.sai.graphql_server.domain.bank.BankAccount;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Service
@Slf4j
public class BalanceService {

    public Map<UUID, BigDecimal> getBalanceFor(Map<UUID, BankAccount> bankAccountIds, String userId) {
        log.info("Requesting bank account ids: {}", bankAccountIds, userId);

        var ids = bankAccountIds.keySet();
        log.info(ids.toString());
//       Set<BigDecimal> bigCrazy = new HashSet<>();
//       var size = ThreadLocalRandom.current().nextInt(250, 500);
//       var littleCrazy = new LinkedHashSet<BigDecimal>(size);
//       IntStream.range(0, size).forEach(nextInt -> littleCrazy.add(BigDecimal.valueOf(nextInt)));
//       bigCrazy.addAll(littleCrazy);

        return Map.of(
                UUID.fromString("770e9b38-0195-4af4-a784-89954fe127f1"), BigDecimal.ONE,
                UUID.fromString("770e9b38-0195-4af4-a784-89954fe127f3"), BigDecimal.TEN);
    }
}
