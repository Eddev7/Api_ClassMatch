package br.com.projeto.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.User;
import br.com.projeto.api.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controllers {

    @Autowired
    private Repository action;

    @SuppressWarnings("null") // suspender o aviso de null no save();
    @PostMapping("/user")
    public User register(@RequestBody User user) {
        BCryptPasswordEncoder cript = new BCryptPasswordEncoder();
        String hash = cript.encode(user.getPassword_Hash());
        user.setPassword_Hash(hash);   
        return action.save(user);
    }

    @GetMapping("/")
    public String home() {
        return "API REST - Class Match";
    }
        
    // @GetMapping("/duplo/{num}")
    // public String duplo(@PathVariable Integer num) {
    //     int duplo = 2 * num;
    //     return "Resultado: " + duplo;
    // }
}
