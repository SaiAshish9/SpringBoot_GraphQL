package com.sai.graphql_server.domain.bank.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class  CreateBankAccountInput {

    @NotBlank
    String firstName;
    int age;

}
