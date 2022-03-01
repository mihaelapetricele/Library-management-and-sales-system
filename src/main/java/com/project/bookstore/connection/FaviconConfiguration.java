//package com.project.bookstore.connection;
//
//import jdk.internal.loader.Resource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
//import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//@Configuration
//public class FaviconConfiguration {
//
//    @Bean
//    public SimpleUrlHandlerMapping faviconHandlerMapping() {
//        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//        mapping.setOrder(Integer.MIN_VALUE);
//        mapping.setUrlMap(Collections.singletonMap("/favicon.ico",
//                faviconRequestHandler()));
//        return mapping;
//    }
//
//    @Bean
//    protected ResourceHttpRequestHandler faviconRequestHandler() {
//        ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
//        requestHandler.setLocations(Arrays
//                . <Resource> asList(new ClassPathResource("/src")));
//        return requestHandler;
//    }
//
//}