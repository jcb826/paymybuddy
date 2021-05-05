package com.PayMyBudy.service;

import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.ConnectionReposiroty;
import com.PayMyBudy.repository.TransferRepository;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.AddConnectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service("ConnectionService")
public class ConnectionService {

    @Autowired
    private ConnectionReposiroty connectionRepository;

    public ConnectionService(ConnectionReposiroty connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public void addConnection(final AddConnectionForm form) {
        /*
        Optional<User> user = userRepository
                .findUserByMail(form.getEmail());
        String email =user.get().getEmail();
        Connection connection = new Connection();


        connection.setUserId(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return userRepository.save(userModel);


         */
    }


}
