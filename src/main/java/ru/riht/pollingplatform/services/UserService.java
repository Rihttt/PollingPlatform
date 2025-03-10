package ru.riht.pollingplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.riht.pollingplatform.models.User;
import ru.riht.pollingplatform.models.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
