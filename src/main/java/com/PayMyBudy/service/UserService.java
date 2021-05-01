package com.PayMyBudy.service;

import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.LoginForm;
import com.PayMyBudy.service.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("UserService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registration(final RegistrationForm form) {
        User userModel = populateCustomerData(form);
        return userRepository.save(userModel);
    }

    private User populateCustomerData(final RegistrationForm form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setMail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return user;
    }


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
/*
public void signin(LoginForm form){

boolean userExists = userRepository
        .findUserByMail(form.getEmail())
        .isPresent();
if(userExists){
    String rawPassword= passwordEncoder.encode(form.getPassword());
   Optional user =userRepository.findUserByMail(form.getEmail());
    passwordEncoder.matches(rawPassword,user.stream());
}
}

 */



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
    /*
    public void registration(RegistrationForm form) {
        User user = new User();
        //
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            throw new RuntimeException("password and confirm are not the same !");

        }
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setMail(form.getEmail());
        // to do encode password
        user.setPassword(form.getPassword());
        userRepository.save(user);

    }
    */

/*  public void login(LoginForm form) {
        User user = new User();
        userRepository.findUserByMail(form.getEmail());
        //
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            throw new RuntimeException("password and confirm are not the same !");

        }
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setMail(form.getEmail());
        // to do encode password
        user.setPassword(form.getPassword());
        userRepository.save(user);

    }
 */

}