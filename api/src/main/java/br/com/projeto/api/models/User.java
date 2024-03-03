package br.com.projeto.api.models;

import org.checkerframework.common.aliasing.qual.Unique;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="users")
public class User {
    
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;
    
    @NonNull
    @Unique
    private String email;
    
    @NonNull
    private String password_Hash;
    
    @NonNull
    private String type;

    // metodos Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword_Hash() {
        return password_Hash;
    }
    public String getType() {
        return type;
    }

    // metodos Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword_Hash(String password_Hash) {
        this.password_Hash = password_Hash;
    }
    public void setType(String type) {
        this.type = type;
    }
}
