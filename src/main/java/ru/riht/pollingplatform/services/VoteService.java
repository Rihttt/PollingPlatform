package ru.riht.pollingplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.riht.pollingplatform.models.Option;
import ru.riht.pollingplatform.models.Poll;
import ru.riht.pollingplatform.models.User;
import ru.riht.pollingplatform.models.Vote;
import ru.riht.pollingplatform.models.repository.VoteRepository;

import java.util.Optional;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    public boolean hasUserVoted(Optional<User> user, Poll poll) {
        return voteRepository.existsByUserAndPoll(user, poll);
    }

    public void castVote(User user, Poll poll, Option option) {
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setPoll(poll);
        vote.setOption(option);
        voteRepository.save(vote);
    }
}
