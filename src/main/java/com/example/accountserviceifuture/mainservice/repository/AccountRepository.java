package com.example.accountserviceifuture.mainservice.repository;

import com.example.accountserviceifuture.mainservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
