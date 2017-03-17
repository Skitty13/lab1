package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 17/03/2017.
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

}
