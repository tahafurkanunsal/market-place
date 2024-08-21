package com.tfunsal.marketplace.repository;

import com.tfunsal.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    boolean existsByEmail(String email);
}
