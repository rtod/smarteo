package com.toader.smarteo.service;

import com.toader.smarteo.entity.User;
import com.toader.smarteo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        //TODO: validate user
        return userRepository.save(user);
    }

    @Override
    public User deleteUserById(Long userId) {
        User user = userRepository.getUserById(userId);
        userRepository.deleteById(userId);
        return user;
    }
}
