package br.com.projeto.api.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.models.User;

public interface Repository extends CrudRepository<User, Integer> {
    
}
