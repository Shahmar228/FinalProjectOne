package com.finalProject.Project.controller;


import com.finalProject.Project.model.Account;
import com.finalProject.Project.service.MainService;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/computer-shop")
@AllArgsConstructor
public class MainController {


    private final   MainService mainService;


    @GetMapping
   public String getPage(Model model){
        model.addAttribute("computer_list", mainService.getComputerList());
        return "shop";
    }

    @GetMapping("/sign-up")
    public String getSignUpPage(Model model){
        model.addAttribute("account", new Account());
        return "signup";
    }

    @PostMapping
    public String saveAccount(@ModelAttribute("account") Account theAccount){
mainService.saveAccount(theAccount);
return "redirect:/login";
    }

}
