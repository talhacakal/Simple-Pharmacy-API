package com.nomal.pharmacy.business.concretes;

import com.nomal.pharmacy.business.abstracts.CategoryService;
import com.nomal.pharmacy.dataAccess.CategoryDao;
import com.nomal.pharmacy.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager  implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return this.categoryDao.findAll();

    }

    @Override
    public ResponseEntity<Category> save(Category category) {
        Category newCategory = this.categoryDao.save(category);
        return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
    }
}
