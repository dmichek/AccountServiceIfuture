package com.example.accountserviceifuture.clienttest.service;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

public class GetService implements Callable<Boolean> {

    private final Integer fromId;

    private final Integer toId;

    public GetService(Integer from, Integer to) {
        this.fromId = from;
        this.toId = to;
    }

    @Override
    public Boolean call() {

        RestTemplate restTemplate = new RestTemplate();

        for (int i = fromId; i <= toId; i++) {
            restTemplate.getForObject(String.format("http://localhost:8080/account/getAmount/%d", i), String.class);
        }

        return true;
    }
}
