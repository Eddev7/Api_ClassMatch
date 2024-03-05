package br.com.projeto.api.models;

import org.springframework.stereotype.Component;

@Component
public class Menssage {
    
    private String menssage;

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

}
