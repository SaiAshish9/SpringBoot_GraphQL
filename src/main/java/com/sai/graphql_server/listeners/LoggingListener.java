package com.sai.graphql_server.listeners;

import graphql.kickstart.servlet.core.GraphQLServletListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingListener implements GraphQLServletListener {

    private final Clock clock;

    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response){

         var startTime = Instant.now(clock);
         log.info("Received graphql request");

         return new RequestCallback() {
             @Override
             public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                 RequestCallback.super.onSuccess(request, response);
             }

             @Override
             public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
                 RequestCallback.super.onError(request, response, throwable);
             }

             @Override
             public void onFinally(HttpServletRequest request, HttpServletResponse response) {
//                 log.info("Completed Request, Time Taken: {}",
//                         Duration.between(startTime, Instant.now(clock))
//                 );
             }
         };
    }

}
