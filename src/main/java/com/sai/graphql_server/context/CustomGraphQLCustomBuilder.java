package com.sai.graphql_server.context;

import com.sai.graphql_server.context.dataloader.DataLoaderRegistryFactory;
import graphql.kickstart.execution.context.GraphQLKickstartContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;
import jakarta.websocket.server.HandshakeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class CustomGraphQLCustomBuilder implements GraphQLServletContextBuilder {

    private final DataLoaderRegistryFactory dataLoaderRegistryFactory;

    @Override
    public GraphQLKickstartContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        var userId = httpServletRequest.getHeader("user_id");
        var context = DefaultGraphQLServletContext.createServletContext()
                .with(httpServletRequest)
                .with(httpServletResponse)
                .with(dataLoaderRegistryFactory.create(userId))
                .build();
        return new CustomGraphQLContext(userId, context);
    }

    @Override
    public GraphQLKickstartContext build(Session session, HandshakeRequest handshakeRequest) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext()
                .with(session)
                .with(handshakeRequest)
                .build();
    }

    @Override
    public GraphQLKickstartContext build() {
        return null;
    }
}
