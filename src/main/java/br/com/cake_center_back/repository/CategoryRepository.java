package br.com.cake_center_back.repository;

import br.com.cake_center_back.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}