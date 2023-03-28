package com.zhihuang.ontodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhihuang.ontodo.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HelloController {

    @Autowired
    UserService userService;

    // @GetMapping("/")
    // public String index() {
    // return "Hello, " + userService.getById(1l).getUsername() + "! Greetings from
    // Spring Boot!";
    // }

    @GetMapping("/info")
    public String info() {
        return "Hello! On To Do!";
    }
}
