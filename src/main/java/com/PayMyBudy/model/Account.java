package com.PayMyBudy.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class Account {

    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
    @SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "ACCOUNT_SEQ")


    private Integer accountId;
     @OneToOne
    private User user;
    private Double amount;
    private LocalDate date;

    public Account plus (double amount){

        this.amount+=amount;
        return this;
    }

    public Account minus (double amount){

        this.amount-=amount;
        return this;
    }
}
