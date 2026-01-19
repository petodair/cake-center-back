package br.com.cake_center_back.repository;

import br.com.cake_center_back.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser(){
        User user = createUser("Peterson","peterson@gmail.com");
        UUID id = userRepository.save(user).getId();

        User userGetted = userRepository.findById(id).orElse(null);

        Assertions.assertNotNull(userGetted);
    }

    @Test
    void deleteUserById(){
        User user = createUser("Peterson","peterson@gmail.com");
        this.userRepository.save(user);

        UUID id = user.getId();
        this.userRepository.deleteById(id);

        User userGetted = userRepository.findById(id).orElse(null);
        Assertions.assertNull(userGetted);

    }

    private User createUser(String name, String email) {
        User user = new User();
        user.setUsername(name);
        user.setPassword("1234");
        user.setEmail(email);
        return user;
    }
}
