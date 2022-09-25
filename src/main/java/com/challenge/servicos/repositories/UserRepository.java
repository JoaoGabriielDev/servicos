package com.challenge.servicos.repositories;

import com.challenge.servicos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
