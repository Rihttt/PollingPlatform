package ru.riht.pollingplatform.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.riht.pollingplatform.models.User;

import ru.riht.pollingplatform.services.UserService;

@Controller
public class UserController {
   @Autowired
    public UserService userService;

    @GetMapping("/user/profile")
    public String userProfile(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);

        model.addAttribute("user", user);
        return "user-profile";
    }
}
