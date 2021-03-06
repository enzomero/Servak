package com.jonny.viewservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@PropertySource(value="classpath:service.properties")
public class CommonModelService {

    @Value(value = "${service.port}")
    private String PORT;
    @Value(value = "${service.host}")
    private String HOST;
    @Value(value = "${service.root.user}")
    private String ROOT;

    private final RestTemplate rest;

    @Autowired
    private CommonModelService(final RestTemplateBuilder builder) {
        this.rest = builder.build();
    }

}
