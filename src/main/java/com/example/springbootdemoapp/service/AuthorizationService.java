package com.example.springbootdemoapp.service;

import com.example.springbootdemoapp.Authorities;
import com.example.springbootdemoapp.exceptions.InvalidCredentials;
import com.example.springbootdemoapp.exceptions.UnauthorizedUser;
import com.example.springbootdemoapp.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password){
        if(isEmpty(user) || isEmpty(password)){
            throw new InvalidCredentials("User name or password is empty");
        }
        var authorities = userRepository.getUserAuthorities(user);
        if (isEmpty(authorities)){
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return authorities;
    }

    private boolean isEmpty(String str){
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str){
        return str == null || str.isEmpty();
    }
}
