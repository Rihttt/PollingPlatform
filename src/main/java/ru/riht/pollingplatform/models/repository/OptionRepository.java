package ru.riht.pollingplatform.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.riht.pollingplatform.models.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
}
