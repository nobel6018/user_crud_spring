package com.cloudy.simplespring.service;

import com.cloudy.simplespring.domain.User;
import com.cloudy.simplespring.exception.UserNotFoundException;
import com.cloudy.simplespring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User " + id + " doesn't exist"));
    }

    @Transactional
    public Long signUp(User user) {
        userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException("User " + id + " doesn't exist");
        }
    }

    @Transactional
    public void updatePassword(Long id, String newPassword) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User " + id + " doesn't exist"));
        user.setPassword(newPassword);
        userRepository.save(user);
    }
}
