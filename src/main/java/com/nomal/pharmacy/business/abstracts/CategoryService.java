package com.nomal.pharmacy.business.abstracts;

import com.nomal.pharmacy.entities.concretes.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
public interface CategoryService {

    List<Category> getAll();

    ResponseEntity<Category> save(
            @NotBlank(message = "Name is mandatory") String categoryName);
}
