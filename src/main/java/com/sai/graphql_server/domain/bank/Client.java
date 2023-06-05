package com.sai.graphql_server.domain.bank;

import lombok.Builder;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Builder
public class Client {
    UUID id;
    String firstName;
    List<String> middleNames;
    String lastName;
    Client client;
}
