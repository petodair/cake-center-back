package br.com.cake_center_back.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import br.com.cake_center_back.entity.User;


import java.util.UUID;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser(){
        User user = new User();
        user.setUsername("Peterson");
        user.setPassword("1234");
        user.setEmail("peter@gmail.com");
        UUID id = userRepository.save(user).getId();

        User userGetted = userRepository.findById(id).orElse(null);

        Assertions.assertNotNull(userGetted);
    }

    @Test
    void deleteUserById(){
        User user = this.userRepository.save(
                new User(null, "Maria", "1234", "maria@gmail.com", null)
        );
        UUID id = user.getId();
        this.userRepository.deleteById(id);
        User userGetted = userRepository.findById(id).orElse(null);
        Assertions.assertNull(userGetted);

    }
  
}