package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
