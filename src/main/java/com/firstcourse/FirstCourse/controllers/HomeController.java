package com.firstcourse.FirstCourse.controllers;


import com.firstcourse.FirstCourse.UserService;
import com.firstcourse.FirstCourse.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("user", new User());
        return "home/index";
    }

//    @RequestMapping(value = "login", method =RequestMethod.POST)
//    public String login(){
//
//    }

    @RequestMapping(value= "registration", method = RequestMethod.POST)
    public String registration(User user){
        userService.saveUser(user);
        return "redirect:";
    }


}
