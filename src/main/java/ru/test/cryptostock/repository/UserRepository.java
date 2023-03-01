package ru.test.cryptostock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.cryptostock.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);


}
