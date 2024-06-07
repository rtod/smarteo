package com.toader.smarteo.service;

import com.toader.smarteo.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> fetchUserList();

    User updateUser(User user, Long userId);

    User deleteUserById(Long userId);
}
