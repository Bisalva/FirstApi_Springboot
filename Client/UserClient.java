package com.example.demo;

import com.example.demo.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class UserClient {
    private final String API_URL = "https://jsonplaceholder.typicode.com/users";

    public List<User> fetchUsers() {
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject(API_URL, User[].class);
        return Arrays.asList(users);
    }
}
