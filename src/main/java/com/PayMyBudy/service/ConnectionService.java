package com.PayMyBudy.service;

import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.ConnectionReposiroty;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.AddConnectionForm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("ConnectionService")
public class ConnectionService {


    private final ConnectionReposiroty connectionRepository;
    private final UserRepository userRepository;

    public ConnectionService(ConnectionReposiroty connectionRepository, UserRepository userRepository) {
        this.connectionRepository = connectionRepository;
        this.userRepository = userRepository;
    }

    public void addConnection(final AddConnectionForm form) {

        User user = userRepository
                .findUserByMail(form.getEmail())
                .orElseThrow(()->new RuntimeException("user with email "+form.getEmail()+" not found"));
        String connectedUserMail = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User userConnected = userRepository
                .findUserByMail(connectedUserMail)
                .orElseThrow(()->new RuntimeException("user with email "+form.getEmail()+" not found"));
        Connection connection = new Connection();
        connection.setUser1(userConnected);
        connection.setUser2(user);
     connectionRepository.save(connection);



    }
    public List <String> findConnectionsEmail(){
        String connectedUserMail = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
return connectionRepository.findConnectionsByUser1Email(connectedUserMail).stream().map(Connection::getUser1).map(User::getEmail).collect(Collectors.toList());

    }


}
