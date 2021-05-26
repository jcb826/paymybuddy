package com.PayMyBudy.repository;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    // interface qui point sur la base
    @Query("SELECT a FROM Account a WHERE a.id= :id")
    Account findAccountByUserId(Integer id );
}