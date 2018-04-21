package com.example.easynotes.repository;

import com.example.easynotes.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findByTitle(String title);
}
