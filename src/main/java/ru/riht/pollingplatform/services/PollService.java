package ru.riht.pollingplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ru.riht.pollingplatform.models.Poll;
import ru.riht.pollingplatform.models.User;
import ru.riht.pollingplatform.models.repository.PollRepository;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public Page<Poll> getAllPolls(Pageable pageable) {
        return pollRepository.findAll(pageable);
    }

    public Poll createPoll(Poll poll, User creator) {
        poll.setCreator(creator);
        return pollRepository.save(poll);
    }

    public Poll getPollById(Long id) {
        return pollRepository.findById(id).orElse(null);
    }
}
