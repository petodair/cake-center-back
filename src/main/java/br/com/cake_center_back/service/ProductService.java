package br.com.cake_center_back.service;

import br.com.cake_center_back.entities.Product;
import br.com.cake_center_back.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }
}
