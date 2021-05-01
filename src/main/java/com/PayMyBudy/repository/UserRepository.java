package com.PayMyBudy.repository;

import com.PayMyBudy.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // attention HQL on pointe sur l objets  du code et pas sur la base en direct
    // au besoin si on veux faire du vrai sql rajouter ,nativeQuery = true) apres les guillements
@Query(value="SELECT u FROM User u WHERE u.mail=:mail")
public Optional<User> findUserByMail(String mail);

}
