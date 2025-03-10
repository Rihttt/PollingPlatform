package ru.riht.pollingplatform.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.riht.pollingplatform.models.Poll;
import ru.riht.pollingplatform.models.User;
import ru.riht.pollingplatform.models.Vote;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByUserAndPoll(Optional<User> user, Poll poll);
}
