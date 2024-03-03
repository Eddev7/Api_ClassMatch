package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.models.User;

public interface Repository extends CrudRepository<User, Integer> {
    
    @SuppressWarnings("null")
    List<User> findAll();

    User findById(int id);
}
