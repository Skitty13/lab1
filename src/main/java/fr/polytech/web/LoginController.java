package fr.polytech.web;

import fr.polytech.business.data.User;
import fr.polytech.business.services.interfaces.SecurityService;
import fr.polytech.business.services.interfaces.UserService;
import fr.polytech.business.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UserService     userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator   userValidator;

    /////////////////
    // Authentication
    //////

    @RequestMapping("/login")
    public String loginPage(Model model, String error){
        if (error != null)
            model.addAttribute("error", "Mauvais username ou password !");

        return "login";
    }

    /////////////////
    // Registration
    //////

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors())
            return "register";

        userService.save(userForm);
        model.addAttribute("registered", "Merci pour votre inscritpion. " + userForm.getUsername());

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/";
    }
}
