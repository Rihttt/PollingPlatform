package ru.riht.pollingplatform.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.riht.pollingplatform.models.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

}
