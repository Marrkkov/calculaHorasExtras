package cl.markov.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLogin(
        ModelMap viewMap,
        @RequestParam(name = "error", required = false) String error) {
        if (error != null) {
            viewMap.put("error", true);

        }

        return "/auth/login";
    }

    @GetMapping("/denied-page")
    public String forbidden() {
        return "error/403";
    }

//    @GetMapping("/logout")
//    public String showLogOut() {
//        return "login/logout";
//    }

    @GetMapping("/admin")
    public String showSignIn() {
        return "admin/admin";
    }

}