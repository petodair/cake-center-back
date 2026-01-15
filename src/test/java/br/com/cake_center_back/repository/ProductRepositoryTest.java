package br.com.cake_center_back.repository;

import br.com.cake_center_back.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void saveProduct(){
        Product product = new Product();
        product.setName("Cake");
        product.setDescription("lorem ipsum");
        product.setPrice(BigDecimal.valueOf(49.9));

        this.productRepository.save(product);

        Product savedProduct = this.productRepository.findById(product.getId()).get();

        Assertions.assertNotNull(savedProduct);
    }

    @Test
    void updateProduct(){

        Product product = new Product();
        product.setName("Cake");
        product.setDescription("lorem ipsum");
        product.setPrice(BigDecimal.valueOf(49.9));

        Long id = this.productRepository.save(product).getId();

        Product productGetted = this.productRepository.findById(id).get();

        String newName = "Pastel";

        productGetted.setName(newName);
        this.productRepository.save(productGetted);

        Product savedProduct = this.productRepository.findById(id).get();

        Assertions.assertEquals(newName, savedProduct.getName());
    }
}
