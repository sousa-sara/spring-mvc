package br.com.fiap.tds2ps.spring_mvc.controller;

import br.com.fiap.tds2ps.spring_mvc.dto.PatientDto;
import br.com.fiap.tds2ps.spring_mvc.model.MedicalHistory;
import br.com.fiap.tds2ps.spring_mvc.model.Patient;
import br.com.fiap.tds2ps.spring_mvc.service.MedicalHistoryService;
import br.com.fiap.tds2ps.spring_mvc.service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {

    private final PatientService patientService;
    private final MedicalHistoryService medicalHistoryService;

    public ConsultationController(PatientService patientService, MedicalHistoryService medicalHistoryService) {
        this.patientService = patientService;
        this.medicalHistoryService = medicalHistoryService;
    }

    @GetMapping("/start")
    public String consultationView(HttpSession session, Model model, @ModelAttribute("user") PatientDto patient) {
        boolean exists = patientService.existsByCpf(patient.getCpf());

        if (exists) {
            String cpf = (String) session.getAttribute("cpf");

            if (cpf.isEmpty()) {
                return "redirect:/"; // Redireciona para o login se não houver dentista na sessão
            }

            Patient patientData = patientService.findByCpf(cpf);

            model.addAttribute("patientCpf", cpf);
            model.addAttribute("patientName", patientData.getFullName());

            return "add-consultation"; // Retorna a página home.html

        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/start")
    public ModelAndView start(@ModelAttribute("user") PatientDto patient, HttpSession session, Model model) {
        boolean exists = patientService.existsByCpf(patient.getCpf());

        if (exists) {
            // Armazena o CPF na sessão
            session.setAttribute("cpf", patient.getCpf());
            // Prepara o modelo e retorna a view
            return prepareConsultationView(patient.getCpf(), model, false);
        }
        return new ModelAndView("add-patient");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("medicalHistory") MedicalHistory medicalHistory, HttpSession session,
            Model model) {
        // Recupera o CPF da sessão
        String cpf = (String) session.getAttribute("cpf");
        if (cpf == null) {
            // Redireciona se o CPF não estiver na sessão
            return new ModelAndView("redirect:/consultation/start");
        }

        // Associa o paciente ao medicalHistory e define a data
        medicalHistory.setPatient(new Patient(cpf));
        medicalHistory.setDate(new Date());

        // Salva o histórico médico
        medicalHistoryService.save(medicalHistory);

        model.addAttribute("successMsg", "Medical record registered!");

        // Prepara o modelo com os dados atualizados e retorna a view
        return prepareConsultationView(cpf, model, true);
    }

    // Método privado para reutilizar a lógica de preparação do modelo e da view
    private ModelAndView prepareConsultationView(String cpf, Model model, Boolean flagSave) {
        Patient patient = patientService.findByCpf(cpf);

        // Busca o histórico médico
        List<MedicalHistory> history = medicalHistoryService.getMedicalHistoryByCpf(cpf);

        // Concatena as informações do histórico médico em uma única string
        StringBuilder medicalHistoryText = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Formato desejado

        for (MedicalHistory h : history) {
            medicalHistoryText.append("Data: ").append(dateFormat.format(h.getDate())).append("\n");
            medicalHistoryText.append("Anamnesis: ").append(h.getAnamnesis()).append("\n");
            medicalHistoryText.append("Prescription: ").append(h.getPrescription()).append("\n");
            medicalHistoryText.append("-----------\n");
        }

        // Adiciona os dados ao modelo
        model.addAttribute("patientCpf", cpf);
        model.addAttribute("patientName", patient.getFullName());
        model.addAttribute("medicalHistoryText", medicalHistoryText.toString());

        if (flagSave) {
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("add-consultation");
        }
    }
}