package com.example.demo;

import com.example.demo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApiApplication implements CommandLineRunner {

    private final UserClient userClient;

    public ClientApiApplication(UserClient userClient) {
        this.userClient = userClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(">>> Usuarios desde API pública:");
        for (User user : userClient.fetchUsers()) {
            System.out.println(user.getName() + " - " + user.getEmail());
        }
    }
}
