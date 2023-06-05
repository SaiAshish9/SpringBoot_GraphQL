//package com.sai.graphql_server.security;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class RequestHeaderPreAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {
//
//    @Override
//    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
//        return request.getHeader("user_id");
//    }
//
//    @Override
//    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
//        return StringUtils.EMPTY;
//    }
//}
