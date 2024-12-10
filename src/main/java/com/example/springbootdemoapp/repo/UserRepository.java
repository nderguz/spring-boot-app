package com.example.springbootdemoapp.repo;

import com.example.springbootdemoapp.Authorities;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private Map<String, List<Authorities>> users;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
        users.put("user", List.of(Authorities.WRITE, Authorities.READ));
        users.put("admin", List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE));
        users.put("user2", List.of(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user) {
        return users.get(user);
    }
}
