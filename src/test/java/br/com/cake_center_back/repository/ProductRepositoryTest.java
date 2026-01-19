package br.com.cake_center_back.repository;

import br.com.cake_center_back.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProduct(){
        Product product = createProduct("Mango Cake", "25.90");

        this.productRepository.save(product);

        Product savedProduct = this.productRepository.findById(product.getId()).get();
        Assertions.assertNotNull(savedProduct);
    }

    @Test
    void updateProduct(){
        Product product = createProduct("Red Velvet Cake", "49.90");
        this.productRepository.save(product);

        product.setName("Pastel");
        this.productRepository.save(product);

        Product savedProduct = this.productRepository.findById(product.getId()).get();
        Assertions.assertEquals("Pastel", savedProduct.getName());
    }

    private Product createProduct(String name, String price){
        Product product = new Product();
        product.setName(name);
        product.setDescription("Descrição padrão para testes");
        product.setPrice(new BigDecimal(price));
        return product;
    }
}
