package com.nomal.pharmacy.dataAccess;

import com.nomal.pharmacy.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
