package com.PayMyBudy.repository;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    // interface qui point sur la base
}