package com.sai.graphql_server.domain.bank;

import lombok.Builder;
import lombok.Setter;

import java.util.UUID;

@Setter
@Builder
public class Asset {
    UUID id;
}
