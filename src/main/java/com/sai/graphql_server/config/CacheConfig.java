package com.sai.graphql_server.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.sai.graphql_server.cache.RequestKey;
import graphql.kickstart.servlet.cache.CachedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Slf4j
@Configuration
public class CacheConfig {

  @Bean
  public Cache<RequestKey, CachedResponse> responseCache() {
    return Caffeine.newBuilder()
        .expireAfterWrite(Duration.ofMinutes(1L))
        .maximumSize(100L)
        .removalListener((key, value, cause) ->
            log.info("Key {} with value {} was removed from the response cache. Cause {}",
                key, value, cause))
        .build();
  }

}
