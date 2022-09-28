package miniProject.accountBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @GetMapping("/new")
    public String signup(){
        System.out.println("TEST \n\n\n\n");
        return "/signup/New";
    }
}
