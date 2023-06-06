package com.sai.graphql_server.cache;

import lombok.Value;

import java.util.List;

@Value
public class RequestKey {

  String userId;
  List<String> queries;

}