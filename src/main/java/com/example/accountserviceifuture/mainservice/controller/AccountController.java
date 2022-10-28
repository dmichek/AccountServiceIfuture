package com.example.accountserviceifuture.mainservice.controller;

import com.example.accountserviceifuture.mainservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAmount/{id}")
    public Long getAmount(@PathVariable Integer id) {
        return accountService.getAmount(id);
    }

    @PostMapping("/addAmount/{id}/{amount}")
    public void addAmount(@PathVariable Integer id, @PathVariable Long amount) {
        accountService.addAmount(id, amount);
    }

}
