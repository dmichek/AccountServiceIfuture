package com.example.accountserviceifuture.clienttest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class TestService {

    @Value("${client.rCount}")
    private int rCount;

    @Value("${client.wCount}")
    private int wCount;

    @Value("${client.idListFrom}")
    private int fromId;
    @Value("${client.idListTo}")
    private int toId;

    public void start() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(rCount + wCount);

        List<Callable<Boolean>> list = new ArrayList<>();

        for (int i = 0; i < wCount; i++) {
            list.add(new AddService(fromId, toId));
        }

        for (int i = 0; i < rCount; i++) {
            list.add(new GetService(fromId, toId));
        }

        executorService.invokeAll(list);

        executorService.shutdown();
    }
}
