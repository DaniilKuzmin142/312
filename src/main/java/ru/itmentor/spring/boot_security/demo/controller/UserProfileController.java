package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.AuthenticationFacade;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserProfileController {

    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public UserProfileController(UserService userService, AuthenticationFacade authenticationFacade) {
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping
    public String userProfile(Model model) {
        String username = authenticationFacade.getAuthentication().getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "user-profile";
    }
}