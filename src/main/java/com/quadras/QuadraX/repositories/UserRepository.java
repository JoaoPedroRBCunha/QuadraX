package com.quadras.QuadraX.repositories;

import com.quadras.QuadraX.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
