package com.example.accountserviceifuture.clienttest.service;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;


public class AddService implements Callable<Boolean> {

    private final int fromId;
    private final int toId;
    private final int AMOUNT = 1;

    public AddService(Integer from, Integer to) {

        this.fromId = from;
        this.toId = to;

    }

    @Override
    public Boolean call() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        for (int i = fromId; i <= toId; i++) {
            restTemplate.postForLocation(String.format("http://localhost:8080/account/addAmount/%d/%d", i, AMOUNT), String.class);
        }

        return true;
    }
}
