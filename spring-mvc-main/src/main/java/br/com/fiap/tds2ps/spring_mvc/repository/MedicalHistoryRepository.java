package br.com.fiap.tds2ps.spring_mvc.repository;

import br.com.fiap.tds2ps.spring_mvc.model.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    List<MedicalHistory> findByPatientCpf(String cpf);

    @Query("SELECT m FROM MedicalHistory m WHERE m.patient.cpf = :cpf ORDER BY m.recordDate DESC")
    List<MedicalHistory> findByPatientCpfOrderByRecordDateDesc(String cpf);
}