package ru.riht.pollingplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.riht.pollingplatform.models.Option;
import ru.riht.pollingplatform.models.Poll;
import ru.riht.pollingplatform.models.User;
import ru.riht.pollingplatform.services.PollService;
import ru.riht.pollingplatform.services.UserService;

import java.security.Principal;
import java.util.List;


@Controller
public class PollCreationController {
    @Autowired
    private UserService userService;
    @Autowired
    private PollService pollService;

    @GetMapping("/poll/create")
    public String showCreateForm(Model model) {
        model.addAttribute("poll", new Poll());
        return "create";
    }

    @PostMapping("/poll/create")
    public String createPoll(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam List<String> options,
                             Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Poll poll = new Poll();
        poll.setTitle(title);
        poll.setDescription(description);

        for (String optionText : options) {
            Option option = new Option();
            option.setText(optionText);
            option.setPoll(poll);
            poll.getOptions().add(option);
        }

        pollService.createPoll(poll, user);
        return "redirect:/polls";
   }
}
