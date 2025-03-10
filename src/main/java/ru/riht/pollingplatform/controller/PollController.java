package ru.riht.pollingplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.riht.pollingplatform.models.Option;
import ru.riht.pollingplatform.models.Poll;
import ru.riht.pollingplatform.models.User;
import ru.riht.pollingplatform.services.OptionService;
import ru.riht.pollingplatform.services.PollService;
import ru.riht.pollingplatform.services.UserService;
import ru.riht.pollingplatform.services.VoteService;

import java.security.Principal;
import java.util.Optional;

@Controller
public class PollController {
    @Autowired
    private PollService pollService;
    @Autowired
    private VoteService voteService;
    @Autowired
    private UserService userService;
    @Autowired
    private OptionService optionService;

    @GetMapping("/polls")
    public String listPolls(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("polls", pollService.getAllPolls(pageable));
        return "polls";
    }

    @GetMapping("/poll/{id}")
    public String showPoll(@PathVariable Long id, Model model, Principal principal) {
        Poll poll = pollService.getPollById(id);
        model.addAttribute("poll", poll);

        if (principal != null){
           User user = userService.findByUsername(principal.getName());
           model.addAttribute("hasVoted", voteService.hasUserVoted(Optional.ofNullable(user), poll));
        }
        return "poll";
    }

    @PostMapping("/poll/{id}/vote")
    public String vote(@PathVariable Long id,
                       @RequestParam Long optionId,
                       Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        User user = userService.findByUsername(principal.getName());
        Poll poll = pollService.getPollById(id);
        Option option = optionService.getOptionById(optionId);

        if (!voteService.hasUserVoted(Optional.ofNullable(user), poll)) {
            voteService.castVote(user, poll, option);
        }

        return "redirect:/poll/" + id;
    }
}
