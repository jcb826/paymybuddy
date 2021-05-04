package com.PayMyBudy.service;

import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.LoginForm;
import com.PayMyBudy.service.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("UserService")
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(final RegistrationForm form) {
        User userModel = populateCustomerData(form);
        return userRepository.save(userModel);
    }

    private User populateCustomerData(final RegistrationForm form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return user;
    }

    //  deuxieme maniere de faire userRepository.findUserByMail(form.getEmail()).filter(u->passwordEncoder.matches(rawPassword,u.getPassword())).isPresent();
    public boolean signin(LoginForm form) {

        Optional<User> user = userRepository
                .findUserByMail(form.getEmail());

        if (user.isPresent()) {


            boolean match = passwordEncoder.matches(form.getPassword(), user.get().getPassword());
            if (match){
                Authentication auth= new UsernamePasswordAuthenticationToken(user.get().getFirstName()+user.get().getLastName(), null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            return match;

        }
        return false;
    }


    /*
        public User getUser(final int id) {
            return userProxy.getUser(id);
        }
    */
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    /*
        public void deleteEmployee(final int id) {
            userProxy.deleteUser(id);;
        }
    */


}