package br.com.fiap.tds2ps.spring_mvc.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @Column(name = "cpf", nullable = false, unique = true)
    public String cpf;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "cep")
    private Long cep;

    @Column(name = "adress_complement", nullable = false)
    private String adressComplement;

    @Column(name = "gender", nullable = false)
    private String gender;

    // Construtor padrão exigido pelo JPA
    public Person() {}

    // Construtor que aceita apenas o CPF
    public Person(String cpf) {
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Long getCep() { return cep; }
    public void setCep(Long cep) { this.cep = cep; }

    public String getAdressComplement() { return adressComplement; }
    public void setAdressComplement(String adressComplement) { this.adressComplement = adressComplement; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}