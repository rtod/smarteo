package com.toader.smarteo.repository;

import com.toader.smarteo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User getUserById(Long userId);
}
