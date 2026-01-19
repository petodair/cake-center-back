package br.com.cake_center_back.repository;

import br.com.cake_center_back.entity.Product;
import br.com.cake_center_back.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void saveProduct(){
        User user = createAndSaveUser("Peterson","peterson@gmail.com");
        Product product = createProduct("Mango Cake", "25.90", user);

        this.productRepository.save(product);

        Product savedProduct = this.productRepository.findById(product.getId()).get();
        Assertions.assertNotNull(savedProduct);
    }

    @Test
    void updateProduct(){
        User user = createAndSaveUser("Peterson", "peter@gmail.com");
        Product product = createProduct("Red Velvet Cake", "49.90", user);
        this.productRepository.save(product);

        Product newProduct = this.productRepository.findById(product.getId()).get();
        newProduct.setName("Pastel");
        this.productRepository.save(newProduct);

        Product savedProduct = this.productRepository.findById(product.getId()).get();
        Assertions.assertEquals("Pastel", savedProduct.getName());
    }

    @Test
    void listProductsByUser(){
        User user = createAndSaveUser("Peterson", "peterson@gmail.com");
        Product p1 = createProduct("Mango Cake", "25.90", user);
        Product p2 = createProduct("Red Velvet Cake", "49.90", user);

        this.productRepository.saveAll(List.of(p1,p2));

        List<Product> products = this.productRepository.findByUser(user);
        Assertions.assertEquals(2, products.size());
    }

    @Test
    void deleteProduct(){
        User user = createAndSaveUser("Peterson", "peterson@gmail.com");
        Product product = createProduct("Mango Cake", "25.90", user);
        this.productRepository.save(product);

        productRepository.delete(product);

        Product deletedProduct = this.productRepository.findById(product.getId()).orElse(null);
        Assertions.assertNull(deletedProduct);
    }

    private User createAndSaveUser(String username, String email){
        User user = new User(null, username,"1234", email);
        return this.userRepository.save(user);
    }

    private Product createProduct(String name, String price, User user){
        Product product = new Product();
        product.setName(name);
        product.setDescription("Descrição padrão para testes");
        product.setPrice(new BigDecimal(price));
        product.setUser(user);
        return product;
    }
}
