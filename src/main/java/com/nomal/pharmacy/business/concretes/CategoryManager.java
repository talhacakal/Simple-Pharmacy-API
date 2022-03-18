package com.nomal.pharmacy.business.concretes;

import com.nomal.pharmacy.business.abstracts.CategoryService;
import com.nomal.pharmacy.core.exception.AlreadyExistsException;
import com.nomal.pharmacy.core.exception.RecordNotFoundException;
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
        List<Category> categories = this.categoryDao.findAll();

        if (categories.size() == 0){
            throw new RecordNotFoundException("Record not found.");
        }

        return categories;

    }

    @Override
    public ResponseEntity<Category> save(String categoryName) {

        Category category = this.categoryDao.getCategoryByCategoryName(categoryName);

        if (category != null){
            throw new AlreadyExistsException(categoryName + " already exist");
        }

        category = this.categoryDao.save(new Category(0, categoryName));
        return new ResponseEntity<Category>(category, HttpStatus.CREATED);
    }
}
