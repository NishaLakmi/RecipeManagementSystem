package com.Employee.Directory.Individual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public boolean registerUser(String username, String email, String user_password) {

        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent() ){
            return false;
        }
        else{
            User newuser = new User();

            newuser.setUsername(username);
            newuser.setEmail(email);
            newuser.setUser_password(user_password);
            userRepository.save(newuser);

            return true;
        }

    }


    public boolean verifyUser(String username, String userPassword) {

        boolean results;

        Optional<User> user = userRepository.findByUsername(username);
        if((user.isPresent() && user.get().getUsername().equals(username))){
            if( user.get().getUser_password().equals(userPassword)){
                return true;
            }
            else{

                return false;
            }

        }
        else{
            return false;
        }


    }




}