package ru.riht.pollingplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.riht.pollingplatform.models.Option;
import ru.riht.pollingplatform.models.repository.OptionRepository;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public Option getOptionById(Long id) {
        return optionRepository.findById(Math.toIntExact(id)).orElse(null);
    }
}
