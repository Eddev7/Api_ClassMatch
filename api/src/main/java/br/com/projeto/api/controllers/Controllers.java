package br.com.projeto.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controllers {

    @GetMapping("/")
    public String home() {
        return "API REST - Class Match";
    }
        
    @GetMapping("/Hello")
    public String mensagem() {
        return "Hello World";
    }

    @GetMapping("/duplo/{num}")
    public String duplo(@PathVariable Integer num) {
        int duplo = 2 * num;
        return "Resultado: " + duplo;
    }

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        return user;
    }
}
