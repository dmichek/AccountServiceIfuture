package com.example.accountserviceifuture.mainservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "balance")
    private long balance;

}
