package br.com.fiap.tds2ps.spring_mvc.controller;

import br.com.fiap.tds2ps.spring_mvc.dto.PatientDto;
import br.com.fiap.tds2ps.spring_mvc.dto.PersonDto;
import br.com.fiap.tds2ps.spring_mvc.service.DentistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final DentistService dentistService; // Adicionando o serviço de dentista

    public HomeController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/")
    public ModelAndView index(Model model) {
        model.addAttribute("user", new PersonDto());
        return new ModelAndView("index");
    }

    @PostMapping("/sign-in")
    public ModelAndView signIn(Model model, @ModelAttribute("user") PersonDto user, HttpSession session) {
        // Verifica se o CPF do dentista existe no banco
        if (dentistService.existsByCpf(user.getCpf())) {
            // Se existir, prossegue com o login
            model.addAttribute("loggedAs", "Logged as " + user.getCpf());
            model.addAttribute("patientLazy", new PatientDto());
            session.setAttribute("cpf", user.getCpf());
            return new ModelAndView("home");
        } else {
            // Se não existir, retorna para a página de login com uma mensagem de erro
            model.addAttribute("errorMsg", "CPF not found. Check your credentials.");
            model.addAttribute("user", new PersonDto()); // Reinicia o formulário
            return new ModelAndView("index");
        }
    }
}