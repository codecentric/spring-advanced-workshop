package de.codecentric.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FarmerController {

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/farmer/index")
    public String farmerIndex() {
        return "farmer/index";
    }

    @RequestMapping("/farmer/edit")
    public String farmerEdit() {
        return "farmer/edit";
    }

    @RequestMapping("/status")
    // Lösung Bonus 3
    @Secured("ROLE_USER")
    public String status() {
        return "status";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
