package br.com.fiap.tds2ps.spring_mvc.controller;

import br.com.fiap.tds2ps.spring_mvc.dto.PatientDto;
import br.com.fiap.tds2ps.spring_mvc.model.Patient;
import br.com.fiap.tds2ps.spring_mvc.service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/save")
    public ModelAndView addPatient(@ModelAttribute("patient") PatientDto patientDto,
            RedirectAttributes redirectAttributes) {
        // Verifica se o paciente já existe pelo CPF
        if (patientService.existsByCpf(patientDto.getCpf())) {
            redirectAttributes.addFlashAttribute("errorMsg", "Patient is already registered!");
            return new ModelAndView("redirect:/patient/add"); // Redireciona para a página de cadastro
        }

        // Se não existe, salva o paciente
        Patient savedPatient = patientService.savePatient(patientDto);
        redirectAttributes.addFlashAttribute("successMsg",
                "Successful registered patient: " + savedPatient.getFullName());

        return new ModelAndView("redirect:/"); // Redireciona para a página inicial
    }

    // Método para exibir o formulário de cadastro (caso não exista)
    @GetMapping("/add")
    public ModelAndView showAddPatientForm(Model model) {
        model.addAttribute("patient", new PatientDto());
        return new ModelAndView("add-patient"); // Assumindo que o template é add-patient.html
    }
}