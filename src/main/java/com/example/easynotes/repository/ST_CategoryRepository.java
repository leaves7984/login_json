package com.example.easynotes.repository;

import com.example.easynotes.model.ST_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ST_CategoryRepository extends JpaRepository<ST_Category, Long> {

    public ST_Category findByTitle(String title);

}
