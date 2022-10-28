package com.example.accountserviceifuture.clienttest.controller;

import com.example.accountserviceifuture.clienttest.service.TestService;
import com.example.accountserviceifuture.mainservice.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestClientController {

    private final TestService testService;

    @Autowired
    public TestClientController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/start")
    public void start() throws InterruptedException {
        testService.start();
    }

    @GetMapping("/statistic")
    public String getStatistic() throws InterruptedException {
        return Statistic.get();
    }

    @GetMapping("/resetstat")
    public void resetStatistic() {
        Statistic.resetStatistic();
    }


}
