package com.nomal.pharmacy.business.abstracts;

import com.nomal.pharmacy.entities.concretes.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    ResponseEntity<Category> save(Category category);
}
