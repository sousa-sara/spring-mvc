package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.model.MedicalHistory;
import br.com.fiap.tds2ps.spring_mvc.repository.MedicalHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    public void save(MedicalHistory medicalHistory) {
        medicalHistoryRepository.save(medicalHistory);
    }

    public List<MedicalHistory> getMedicalHistoryByCpf(String cpf) {
        return medicalHistoryRepository.findByPatientCpfOrderByRecordDateDesc(cpf);
    }
}