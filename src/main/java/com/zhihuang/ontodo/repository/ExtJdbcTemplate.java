package com.zhihuang.ontodo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhihuang.ontodo.entity.User;

@Repository
public class ExtJdbcTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getByid(Long id) {
        String sql = "select * from user where id = ?";
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }
}
