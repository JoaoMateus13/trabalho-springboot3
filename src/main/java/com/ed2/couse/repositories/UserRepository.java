package com.ed2.couse.repositories;

import com.ed2.couse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
