package com.PayMyBudy.repository;

import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



    @Repository
    public interface TransferRepository extends CrudRepository<Transfer, Long> {
        // attention HQL on pointe sur l objets  du code et pas sur la base en direct
        // au besoin si on veux faire du vrai sql rajouter ,nativeQuery = true) apres les guillements

        public Optional<Transfer> findTransferByDate(String transfer);
}
