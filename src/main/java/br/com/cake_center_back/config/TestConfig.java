package br.com.cake_center_back.config;

import br.com.cake_center_back.entities.Category;
import br.com.cake_center_back.entities.Order;
import br.com.cake_center_back.entities.User;
import br.com.cake_center_back.enums.OrderStatus;
import br.com.cake_center_back.repository.CategoryRepository;
import br.com.cake_center_back.repository.OrderRepository;
import br.com.cake_center_back.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository,
                      CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Peterson Odair","peter@gmail.com", "12345678");
        User u2 = new User("Maria Clara","maria@gmail.com", "12345678");
        User u3 = new User("Buddy", "buddy@gmail.com","12345678");

        Order o1 = new Order(Instant.now(), OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(Instant.now(), OrderStatus.WAITING_PAYMENT)

        Category c1 = new Category("Cake");
        Category c2 = new Category("Muffin");
        Category c3 = new Category("Cupcake");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
