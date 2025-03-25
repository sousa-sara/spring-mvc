package br.com.fiap.tds2ps.spring_mvc.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cp4_medical_history")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medical_history", nullable = false)
    private Long idMedicalHistory;

    @Column(name = "record_date")
    private Date recordDate;

    @Column(name = "anamnesis")
    private String anamnesis;

    @Column(name = "prescription")
    private String prescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_patient", nullable = false)
    private Patient patient;

    // Construtor padrão
    public MedicalHistory() {}

    // Getters e Setters
    public Long getIdMedicalHistory() { return idMedicalHistory; }
    public void setIdMedicalHistory(Long idMedicalHistory) { this.idMedicalHistory = idMedicalHistory; }

    public Date getDate() { return recordDate; }
    public void setDate(Date date) { this.recordDate = date; }

    public String getAnamnesis() { return anamnesis; }
    public void setAnamnesis(String anamnesis) { this.anamnesis = anamnesis; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}