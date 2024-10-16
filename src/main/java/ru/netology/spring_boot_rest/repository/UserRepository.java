package ru.netology.spring_boot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.spring_boot_rest.Authorities;
import ru.netology.spring_boot_rest.service.AuthorizationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();

        Map<String, String> users = new ConcurrentHashMap<>();
        users.put("user", "user123");
        users.put("admin", "admin123");

        if (users.containsKey(user) && users.get(user).equals(password)) {
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.READ);
            authorities.add(Authorities.DELETE);
        }
        else {
            return new ArrayList<>();
        }
        return authorities;
    }
}
