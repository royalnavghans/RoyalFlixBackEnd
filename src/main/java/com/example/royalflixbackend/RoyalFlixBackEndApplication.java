package com.example.royalflixbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RoyalFlixBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoyalFlixBackEndApplication.class, args);
    }

@GetMapping("/root")
    public String getRoot(){
        return "Hello world";
    }
}
