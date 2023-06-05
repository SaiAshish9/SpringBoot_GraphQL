package com.sai.graphql_server.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ExecutionFactory {

   private final TaskDecorator mdcContextTaskDecorator;

   public Executor newExecutor(){
     var executor = new ThreadPoolTaskExecutor();
     executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
     executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
     executor.setKeepAliveSeconds(0);
     executor.setTaskDecorator(mdcContextTaskDecorator);
     executor.initialize();
     return executor;
   }



}
