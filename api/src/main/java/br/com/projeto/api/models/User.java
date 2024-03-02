package br.com.projeto.api.models;

public class User {
    
    // atributos
    private String identity;
    private String name;
    private String email;
    private String password;
    private String type;

    // metodos Getters
    public String getIdentity() {
        return identity;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getType() {
        return type;
    }

    // metodos Setters
    public void setIdentity(String identity) {
        this.identity = identity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setType(String type) {
        this.type = type;
    }
}
