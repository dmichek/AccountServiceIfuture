package com.example.accountserviceifuture.mainservice.service;

public interface AccountService {

    Long getAmount(Integer id);

    void addAmount(Integer id, Long value);

}
