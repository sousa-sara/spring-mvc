package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.repository.DentistRepository;
import org.springframework.stereotype.Service;

@Service
public class DentistService {

  private final DentistRepository dentistRepository;

  public DentistService(DentistRepository dentistRepository) {
    this.dentistRepository = dentistRepository;
  }

  public boolean existsByCpf(String cpf) {
    return dentistRepository.existsByCpf(cpf);
  }
}