package br.com.cake_center_back.config;

import br.com.cake_center_back.entities.User;
import br.com.cake_center_back.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Peterson Odair","peter@gmail.com", "12345678");
        User u2 = new User("Maria Clara","maria@gmail.com", "12345678");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
