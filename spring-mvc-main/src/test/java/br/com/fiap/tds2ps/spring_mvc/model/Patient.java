package br.com.fiap.tds2ps.spring_mvc.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cp4_patient")
public class Patient extends Person {

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalHistory> medicalHistories;

    // Construtor que aceita apenas o CPF
    public Patient(String cpf) {
        this.cpf = cpf;
    }
    // Construtor padrão
    public Patient() {}

    // Getter e Setter específico
    public List<MedicalHistory> getMedicalHistories() { return medicalHistories; }
    public void setMedicalHistories(List<MedicalHistory> medicalHistories) { this.medicalHistories = medicalHistories; }
}