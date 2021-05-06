package com.PayMyBudy.repository;

import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConnectionReposiroty extends CrudRepository<Connection, Integer> {

    // interface qui point sur la base
}
