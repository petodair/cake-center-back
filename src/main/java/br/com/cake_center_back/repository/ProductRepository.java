package br.com.cake_center_back.repository;

import br.com.cake_center_back.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
