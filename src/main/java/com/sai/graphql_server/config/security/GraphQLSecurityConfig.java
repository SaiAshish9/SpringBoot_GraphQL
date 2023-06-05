//package com.sai.graphql_server.security;

//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;
//
//import javax.servlet.Filter;

//@Configuration
//@Slf4j
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class GraphQLSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
//        authenticationManagerBuilder.authenticationProvider(preAuthenticatedAuthenticationProvider());
//    }
//
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterBefore(createRequestHeaderPreAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .httpBasic().disable()
//                .sessionManagement().disable()
//                .logout().disable()
//                .anonymous().disable();
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/actuator/health");
//    }
//
//    private Filter createRequestHeaderPreAuthenticationFilter() throws Exception {
//       var filter = new RequestHeaderPreAuthenticationFilter();
//       filter.setAuthenticationDetailsSource(new GrantedAuthoritiesAuthenticationDetailsSource());
//       filter.setAuthenticationManager(authenticationManager());
//       filter.setContinueFilterChainOnUnsuccessfulAuthentication(false);
//       return filter;
//    }
//
//    public PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
//        var preAuthProvider = new PreAuthenticatedAuthenticationProvider();
//        preAuthProvider.setPreAuthenticatedUserDetailsService(
//                new PreAuthenticatedGrantedAuthoritiesUserDetailsService()
//        );
//        return preAuthProvider;
//    }
//
//}
