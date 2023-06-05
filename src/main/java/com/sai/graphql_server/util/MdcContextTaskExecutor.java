package com.sai.graphql_server.util;

import graphql.kickstart.servlet.AsyncTaskDecorator;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.stereotype.Component;

@Component
public class MdcContextTaskExecutor implements AsyncTaskDecorator, TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        var mdcContent = MDC.getCopyOfContextMap();
        return () -> {
            try {
                MDC.setContextMap(mdcContent);
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
