package com.finalProject.Project.controller;


import com.finalProject.Project.model.Computer;
import com.finalProject.Project.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("Hello world");
        return "addProduct";
    }

    @PostMapping
    public String saveComputer(
            @ModelAttribute("computer") Computer theComputer
    ){
        mainService.addComputer(theComputer);
        return "redirect:/computer-base";
    }

    @GetMapping("/delete/{id}")
    public String deleteComputerById(@PathVariable("id") long id){
        System.out.println(id);
        mainService.deleteComputerById(id);
        return "redirect:/computer-base";
    }
    @GetMapping("/edit/{id}")
    public String editComputerById(@PathVariable("id") long id, Model model){
Computer computer = mainService.getComputerById(id);
model.addAttribute("computer",computer);
return "addProduct";
    }
}
