package com.celesma.celesmav2.service;

import com.celesma.celesmav2.models.User;
import com.celesma.celesmav2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean isUserExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Хешируем пароль
        userRepository.save(user);
    }

    public boolean authenticate(String email, String rawPassword) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        return userOpt.isPresent() && passwordEncoder.matches(rawPassword, userOpt.get().getPassword());
    }
}

