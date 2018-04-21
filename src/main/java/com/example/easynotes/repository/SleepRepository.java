package com.example.easynotes.repository;

import com.example.easynotes.model.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface SleepRepository extends JpaRepository<Sleep,Long> {
}
