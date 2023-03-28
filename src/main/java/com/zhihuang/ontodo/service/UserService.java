package com.zhihuang.ontodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhihuang.ontodo.entity.User;
import com.zhihuang.ontodo.repository.ExtJdbcTemplate;
import com.zhihuang.ontodo.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    Map<Long, User> users = new HashMap<>();

    @Autowired
    private UserRepository repository;

    @Autowired
    private ExtJdbcTemplate extJdbcTemplate;

    public List<User> findAll() {
        List<User> demos = (List<User>) repository.findAll();
        demos.stream().map(e -> users.put(e.getUserId(), e));
        return demos;
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
        users.put(user.getUserId(), user);
    }

    public User getById(Long id) {
        if (users.containsKey(id)) {
            return users.get(id);
        }
        return extJdbcTemplate.getByid(id);
    }

    public User findByUsername(final String username) {
        findAll();
        return users
                .values()
                .stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst().get();
    }

}
