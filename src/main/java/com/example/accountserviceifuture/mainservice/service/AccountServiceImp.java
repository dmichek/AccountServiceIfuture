package com.example.accountserviceifuture.mainservice.service;

import com.example.accountserviceifuture.mainservice.Statistic;
import com.example.accountserviceifuture.mainservice.model.Account;
import com.example.accountserviceifuture.mainservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Cacheable(cacheNames = "balanceCache", key = "#id")
    @Override
    public Long getAmount(Integer id) {

        Optional<Account> optionalAccount = accountRepository.findById(id);

        Long balance;

        if (optionalAccount.isPresent()) {
            balance = optionalAccount.get().getBalance();
        } else {
            Account account = new Account();
            account.setId(id);

            accountRepository.save(account);

            balance = 0L;
        }

        Statistic.incrementGetCounter();

        return balance;
    }

    @Transactional
    @CacheEvict(cacheNames = "balanceCache", key = "#id")
    @Override
    public void addAmount(Integer id, Long value) {

        Optional<Account> optionalAccount = accountRepository.findById(id);

        Account account = optionalAccount.orElseThrow(() -> {
            throw new IllegalStateException("Account with ID: " + id + " not found.");
        });

        Long totalBalance = account.getBalance() + value;

        account.setBalance(totalBalance);

        accountRepository.save(account);

        Statistic.incrementAddCounter();
    }




}
