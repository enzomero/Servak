package com.jonny.viewservice;

import com.jonny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@PropertySource(value="classpath:service.properties")
public class RegistarationModelService {
    @Value(value = "${service.port}")
    private String PORT;
    @Value(value = "${service.host}")
    private String HOST;
    @Value(value = "${service.root.reg}")
    private String ROOT;

    private final RestTemplate rest;

    @Autowired
    private RegistarationModelService(final RestTemplateBuilder builder) {
        this.rest = builder.build();
    }

    public void save(Integer id, String username, String loginname, String password, String active) {
        User user = new User(id, username, loginname, password, active);
        rest.put(HOST + PORT + ROOT, user);
    }
}
