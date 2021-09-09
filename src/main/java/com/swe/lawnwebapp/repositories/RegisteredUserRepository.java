package com.swe.lawnwebapp.repositories;


import com.swe.lawnwebapp.models.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {


    Optional<RegisteredUser> findByEmail(String email);
}
