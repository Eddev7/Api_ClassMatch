package br.com.projeto.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.User;
import br.com.projeto.api.repository.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserControllers {

    @Autowired
    private Repository action;

    @GetMapping("/")
    public String home() {
        return "API REST - Class Match";
    }

    @SuppressWarnings("null") // suspender o aviso de null no save();
    @PostMapping("/user")
    public User register(@RequestBody User user) {
        // Faz o Hash da Senha
        BCryptPasswordEncoder cript = new BCryptPasswordEncoder();
        String hash = cript.encode(user.getPassword_Hash());
        user.setPassword_Hash(hash);   
        return action.save(user);
    }

    // altera o Usuario.
    @PutMapping("/user")
    public User update(@RequestBody User user) {
        BCryptPasswordEncoder cript = new BCryptPasswordEncoder();
        String hash = cript.encode(user.getPassword_Hash());
        user.setPassword_Hash(hash);   
        return action.save(user);
    }

    // deleta o Usuario.
    @SuppressWarnings("null")
    @DeleteMapping("/user")
    public String delete(@RequestBody User user) {
        action.delete(user);
        return "Usuario Deletado";
    }

    // Lista todos os Usuarios.
    @GetMapping("/user")
    public List<User> select() {
        return action.findAll();
    }

    // Procura Usuario por id.
    @GetMapping("/user/{id}")
    public User selectId(@PathVariable int id) {
        return action.findById(id);
    }

}
