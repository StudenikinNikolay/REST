package ru.netology.studenikin_authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.studenikin_authorizationservice.model.User;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<String, User> users;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
        users.put("Vladimir", new User("Vladimir", "qwerty",
                List.of(Authorities.READ, Authorities.DELETE, Authorities.WRITE)));
        users.put("Irina", new User("Irina", "12345",
                List.of(Authorities.READ, Authorities.WRITE)));
        users.put("Oleg", new User("Oleg", "qwerty",
                List.of(Authorities.READ)));

    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        if (users.containsKey(user) && users.get(user).getPassword().equals(password)) {
            return users.get(user).getAuthorities();

        } else return Collections.emptyList();


    }
}
