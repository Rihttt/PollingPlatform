package ru.riht.pollingplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ru.riht.pollingplatform.models.User;
import ru.riht.pollingplatform.models.repository.UserRepository;
import ru.riht.pollingplatform.config.MyUserDetails;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "не найден"));
    }

    public Optional<MyUserDetails> loadUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(MyUserDetails::new);
    }
}
