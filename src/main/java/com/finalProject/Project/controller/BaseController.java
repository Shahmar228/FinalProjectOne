package com.finalProject.Project.controller;


import com.finalProject.Project.model.Computer;
import com.finalProject.Project.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.ManyToOne;

@Controller
@RequestMapping("/computer-base")
@AllArgsConstructor
public class BaseController {


    private final MainService mainService;


    @GetMapping
    public String getPage(Model model){
        model.addAttribute("computer_list", mainService.getMyComputerList());
        return "base";
    }

    @GetMapping("/add-computer")
    public String addComputer(Model model){
        model.addAttribute("computer", new Computer());
        return "addProduct";
    }

    @PostMapping
    public String saveComputer(
            @ModelAttribute("computer") Computer theComputer
    ){
        mainService.addComputer(theComputer);
        return "redirect:/computer-base";
    }
}
