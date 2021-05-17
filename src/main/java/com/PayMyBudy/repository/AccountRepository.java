package com.PayMyBudy.repository;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    // interface qui point sur la base
}