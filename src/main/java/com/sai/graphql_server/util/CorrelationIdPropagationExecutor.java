package com.sai.graphql_server.util;

import lombok.RequiredArgsConstructor;

import org.slf4j.MDC;

import javax.validation.constraints.NotNull;
import java.util.concurrent.Executor;

import static com.sai.graphql_server.instrumentation.RequestLoggingInstrumentation.CORRELATION_ID;

@RequiredArgsConstructor
public class CorrelationIdPropagationExecutor implements Executor {

    private final Executor delegate;

    public static Executor wrap(Executor executor) {
        return new CorrelationIdPropagationExecutor(executor);
    }

    @Override
    public void execute(@NotNull Runnable command) {
        var correlationId = MDC.get(CORRELATION_ID);
        delegate.execute(() -> {
            try {
                MDC.put(CORRELATION_ID, correlationId);
                command.run();
            } finally {
                MDC.remove(CORRELATION_ID);
            }
        });
    }
}
