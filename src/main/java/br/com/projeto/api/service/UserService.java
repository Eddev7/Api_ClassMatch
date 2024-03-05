package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.projeto.api.models.Menssage;
import br.com.projeto.api.models.User;
import br.com.projeto.api.repository.Repository;

@Service
public class UserService {
    
    @Autowired
    private Menssage menssage;
    
    @Autowired
    private Repository action;

    public ResponseEntity<?> register(User user) {
        if (user.getName().equals("")) {
            menssage.setMenssage("Nome está vazio.");
            return new ResponseEntity<>(menssage, HttpStatus.BAD_REQUEST);
        } else if (user.getEmail().equals("")) {
            menssage.setMenssage("Email está vazio.");
            return new ResponseEntity<>(menssage, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword().equals("")) {
            menssage.setMenssage("Senha está vazio.");
            return new ResponseEntity<>(menssage, HttpStatus.BAD_REQUEST);
        } else if (user.getType().equals("")) {
            menssage.setMenssage("tipo está vazio.");
            return new ResponseEntity<>(menssage, HttpStatus.BAD_REQUEST);
        } else {
            try {
                BCryptPasswordEncoder cript = new BCryptPasswordEncoder();
                String hash = cript.encode(user.getPassword());
                user.setPassword(hash);   
                action.save(user);
                return new ResponseEntity<>(user, HttpStatus.CREATED);    
            } catch(Exception e) {
                menssage.setMenssage("Erro ao criptografar a Senha.");
                return new ResponseEntity<>(menssage, HttpStatus.BAD_REQUEST);    
            }
        }
    }
}
