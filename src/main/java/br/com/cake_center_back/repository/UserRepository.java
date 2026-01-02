package br.com.cake_center_back.repository;

import br.com.cake_center_back.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
