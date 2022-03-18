package com.nomal.pharmacy.api;

import com.nomal.pharmacy.business.abstracts.CategoryService;
import com.nomal.pharmacy.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")   // add new or update
    public ResponseEntity<Category> save(@RequestParam String categoryName){
        return this.categoryService.save(categoryName);
    }


}
