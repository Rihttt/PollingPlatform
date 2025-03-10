package ru.riht.pollingplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.riht.pollingplatform.models.Poll;
import ru.riht.pollingplatform.models.repository.PollRepository;
import ru.riht.pollingplatform.services.PollService;

@Controller
public class MainController {
    @Autowired
    private PollService pollService;

    @GetMapping("/")
    public String listPolls(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("polls", pollService.getAllPolls(pageable));
        return "polls";
    }
}
