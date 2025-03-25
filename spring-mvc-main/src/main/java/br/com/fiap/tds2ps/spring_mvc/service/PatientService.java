package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.dto.PatientDto;
import br.com.fiap.tds2ps.spring_mvc.model.Patient;
import br.com.fiap.tds2ps.spring_mvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setCpf(patientDto.getCpf());
        patient.setFullName(patientDto.getFullName());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());
        patient.setCep(patientDto.getCep());
        patient.setAdressComplement(patientDto.getAdressComplement());
        patient.setGender(patientDto.getGender());

        return patientRepository.save(patient);
    }

    public boolean existsByCpf(String cpf) {
        return patientRepository.existsByCpf(cpf);
    }

    public Patient findByCpf(String cpf) {
        return patientRepository.findByCpf(cpf);
    }
}