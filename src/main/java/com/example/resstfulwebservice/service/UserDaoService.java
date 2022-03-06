package com.example.resstfulwebservice.service;

import com.example.resstfulwebservice.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static Long userCount = 3L;

    static {
        users.add(new User(1L, "test1", LocalDateTime.now(), "pass1", "701010-1111111"));
        users.add(new User(2L, "test2", LocalDateTime.now(), "pass2", "801010-1111111"));
        users.add(new User(3L, "test3", LocalDateTime.now(), "pass3", "901010-1111111"));
    }

    public static List<User> findAll() {
        return users;
    }

    // 람다식으로 표현할 수 있을거같은데..
    public static User findOne(Long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(Long id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    public static User saveUser(User user) {

        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

}
