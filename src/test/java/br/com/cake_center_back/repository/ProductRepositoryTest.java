package br.com.cake_center_back.repository;

import br.com.cake_center_back.entity.Product;
import br.com.cake_center_back.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void saveProduct(){
        Product product = new Product();
        product.setName("Cake");
        product.setDescription("lorem ipsum");
        product.setPrice(BigDecimal.valueOf(49.9));

        User user = new User(null,
                "Maria",
                "1234",
                "maria@gmail.com");

        this.userRepository.save(user);
        product.setUser(user);
        this.productRepository.save(product);

        Product savedProduct = this.productRepository.findById(product.getId()).get();

        Assertions.assertEquals(savedProduct.getUser().getId(), user.getId());
        Assertions.assertNotNull(savedProduct);
    }

    @Test
    void updateProduct(){

        Product product = new Product();
        product.setName("Cake");
        product.setDescription("lorem ipsum");
        product.setPrice(BigDecimal.valueOf(49.9));

        this.productRepository.save(product);

        String newName = "Pastel";

        product.setName(newName);
        this.productRepository.save(product);

        Product savedProduct = this.productRepository.findById(product.getId()).get();

        Assertions.assertEquals(newName, savedProduct.getName());
    }
}
