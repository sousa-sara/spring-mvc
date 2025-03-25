package br.com.fiap.tds2ps.spring_mvc.model;

import br.com.fiap.tds2ps.spring_mvc.model.Person;
import jakarta.persistence.*;

@Entity
@Table(name = "cp4_dentist")
public class Dentist extends Person {

    @Column(name = "cro", nullable = false)
    private String cro;

    @Column(name = "role", nullable = false)
    private String role;

    // Construtor padrão
    public Dentist() {}

    // Getters e Setters específicos
    public String getCro() { return cro; }
    public void setCro(String cro) { this.cro = cro; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}