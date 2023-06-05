package com.sai.graphql_server.context;

import graphql.kickstart.servlet.context.GraphQLServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoaderRegistry;

import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
@Deprecated
public class CustomGraphQLContext implements GraphQLServletContext {

    private final String userId;
    private final GraphQLServletContext context;

    @Override
    public List<Part> getFileParts() {
        return context.getFileParts();
    }

    @Override
    public Map<String, List<Part>> getParts() {
        return context.getParts();
    }

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return context.getHttpServletRequest();
    }

    @Override
    public HttpServletResponse getHttpServletResponse() {
        return context.getHttpServletResponse();
    }


    @Override
    public @NonNull DataLoaderRegistry getDataLoaderRegistry() {
        return context.getDataLoaderRegistry();
    }

    @Override
    public Map<Object, Object> getMapOfContext() {
        return context.getMapOfContext();
    }
}
