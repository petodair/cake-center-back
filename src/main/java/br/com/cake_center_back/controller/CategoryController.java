package br.com.cake_center_back.controller;

import br.com.cake_center_back.entities.Category;
import br.com.cake_center_back.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = this.categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = this.categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

}
